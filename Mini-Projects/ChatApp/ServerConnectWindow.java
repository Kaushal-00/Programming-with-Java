import javax.swing.*;

public class ServerConnectWindow {
    public static void show() {
        JFrame frame = new JFrame("Connect to Server");

        JLabel label = new JLabel("Connect to:");
        JRadioButton localhostBtn = new JRadioButton("Localhost", true);
        JRadioButton ipBtn = new JRadioButton("Enter IP Address");
        JTextField ipField = new JTextField();
        JButton connectBtn = new JButton("Connect");

        ButtonGroup group = new ButtonGroup();
        group.add(localhostBtn);
        group.add(ipBtn);

        label.setBounds(30, 20, 120, 30);
        localhostBtn.setBounds(30, 50, 120, 30);
        ipBtn.setBounds(30, 80, 150, 30);
        ipField.setBounds(30, 110, 250, 30);
        connectBtn.setBounds(100, 160, 100, 30);

        ipField.setEnabled(false);

        ipBtn.addActionListener(e -> ipField.setEnabled(true));
        localhostBtn.addActionListener(e -> ipField.setEnabled(false));

        connectBtn.addActionListener(e -> {
            ChatClient.host = localhostBtn.isSelected() ? "localhost" : ipField.getText().trim();
            if (!ChatClient.host.isEmpty()) {
                frame.dispose();
                ChatClient.connectToServer();
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a valid IP.");
            }
        });

        frame.add(label);
        frame.add(localhostBtn);
        frame.add(ipBtn);
        frame.add(ipField);
        frame.add(connectBtn);

        frame.setSize(320, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
