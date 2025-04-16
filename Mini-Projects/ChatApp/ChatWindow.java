import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChatWindow {
    private static JPanel messagePanel;
    private static JScrollPane scrollPane;
    private static JTextField inputField;

    public static void show() {
        JFrame frame = new JFrame("Chat - " + ChatClient.name);

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(messagePanel);
        scrollPane.setBounds(10, 10, 360, 380);

        inputField = new JTextField();
        JButton sendBtn = new JButton("Send");

        inputField.setBounds(10, 400, 260, 30);
        sendBtn.setBounds(280, 400, 80, 30);

        sendBtn.addActionListener(e -> {
            String msg = inputField.getText().trim();
            if (!msg.isEmpty()) {
                try {
                    ChatClient.dos.writeUTF(msg);
                    addMessage("You: " + msg, true);
                    if (msg.equalsIgnoreCase("exit")) System.exit(0);
                    inputField.setText("");
                } catch (IOException ex) {
                    addMessage("Error sending message.", true);
                }
            }
        });

        frame.setLayout(null);
        frame.add(scrollPane);
        frame.add(inputField);
        frame.add(sendBtn);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void addMessage(String message, boolean isSentByUser) {
        JPanel msgBubble = new JPanel();
        JLabel msgLabel = new JLabel("<html><p style='width:200px'>" + message + "</p></html>");

        msgBubble.setLayout(new FlowLayout(isSentByUser ? FlowLayout.RIGHT : FlowLayout.LEFT));
        msgLabel.setOpaque(true);
        msgLabel.setBackground(new Color(40, 209, 70));
        msgLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        msgBubble.add(msgLabel);
        messagePanel.add(msgBubble);
        messagePanel.revalidate();

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
}
