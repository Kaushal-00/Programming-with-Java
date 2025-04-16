import javax.swing.*;

public class NameInputWindow {
    public static void show() {
        JFrame frame = new JFrame("Enter Your Name");
        JLabel label = new JLabel("Enter your name:");
        JTextField nameField = new JTextField();
        JButton nextBtn = new JButton("Next");

        label.setBounds(30, 30, 120, 30);
        nameField.setBounds(150, 30, 150, 30);
        nextBtn.setBounds(120, 80, 100, 30);

        nextBtn.addActionListener(e -> {
            ChatClient.name = nameField.getText().trim();
            if (!ChatClient.name.isEmpty()) {
                frame.dispose();
                ServerConnectWindow.show();
            } else {
                JOptionPane.showMessageDialog(frame, "Name cannot be empty.");
            }
        });

        frame.add(label);
        frame.add(nameField);
        frame.add(nextBtn);
        frame.setSize(350, 180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
