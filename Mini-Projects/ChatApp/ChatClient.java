import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    private JFrame frame;
    private JPanel messagePanel;
    private JTextField messageField;
    private JButton sendButton;
    private String userName;
    private PrintWriter out;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        new ChatClient().startClient();
    }

    private void startClient() {
        userName = JOptionPane.showInputDialog(frame, "Enter your name:", "Name Required", JOptionPane.PLAIN_MESSAGE);
        if (userName == null || userName.trim().isEmpty()) return;

        String serverIP = JOptionPane.showInputDialog(frame, "Enter Server IP:", "localhost");
        if (serverIP == null || serverIP.trim().isEmpty()) return;

        createGUI();

        try {
            Socket socket = new Socket(serverIP, 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(userName); // Send username to server

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        appendMessage(message);
                    }
                } catch (IOException e) {
                    appendSystemMessage("Disconnected from server.");
                }
            }).start();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Unable to connect to server.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void createGUI() {
        frame = new JFrame("Chat - " + userName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(Color.decode("#F2F2F2"));

        scrollPane = new JScrollPane(messagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        messageField = new JTextField();
        messageField.setFont(new Font("Arial", Font.PLAIN, 14));

        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(0, 168, 107));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Arial", Font.BOLD, 13));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());

        frame.setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            appendOwnMessage(message);
            out.println(message);
            messageField.setText("");
        }
    }

    private void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            if (message.contains(":")) {
                String sender = message.substring(0, message.indexOf(":")).trim();
                String content = message.substring(message.indexOf(":") + 1).trim();

                if (!sender.equals(userName)) {
                    addMessageBubble("[" + sender + "]: " + content, false);
                }
            } else {
                appendSystemMessage(message);
            }
        });
    }

    private void appendOwnMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            addMessageBubble("[You]: " + message, true);
        });
    }

    private void appendSystemMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            JLabel label = new JLabel(message, SwingConstants.CENTER);
            label.setForeground(Color.GRAY);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setBorder(new EmptyBorder(5, 5, 5, 5));
            messagePanel.add(label);
            messagePanel.revalidate();
            scrollToBottom();
        });
    }

    private void addMessageBubble(String text, boolean isSelf) {
        JLabel label = new JLabel("<html><p style=\"width: 200px\">" + text + "</p></html>");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setOpaque(true);
        label.setBorder(new EmptyBorder(10, 15, 10, 15));

        JPanel bubble = new JPanel();
        bubble.setLayout(new BorderLayout());
        bubble.setBorder(new EmptyBorder(5, 10, 5, 10));
        bubble.setOpaque(false);

        if (isSelf) {
            label.setBackground(new Color(0, 168, 107));
            label.setForeground(Color.WHITE);
            bubble.add(label, BorderLayout.EAST);
        } else {
            label.setBackground(new Color(220, 220, 220));
            label.setForeground(Color.BLACK);
            bubble.add(label, BorderLayout.WEST);
        }

        messagePanel.add(bubble);
        messagePanel.revalidate();
        scrollToBottom();
    }

    private void scrollToBottom() {
        SwingUtilities.invokeLater(() ->
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }
}
