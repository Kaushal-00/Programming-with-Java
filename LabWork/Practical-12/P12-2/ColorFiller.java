import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorFiller {
    public static void main(String[] args) {
        JFrame frame = new JFrame("I am a JFrame");
        frame.setSize(400, 235);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Left panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GREEN);
        buttonPanel.setBounds(0, 0, 150, 200);
        buttonPanel.setLayout(new GridLayout(3, 1, 5, 5));

        JButton redButton = new JButton("Red");
        JButton blueButton = new JButton("Blue");
        JButton greenButton = new JButton("Green");

        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(greenButton);

        // Right panel to show color
        JPanel colorPanel = new JPanel();
        colorPanel.setBounds(150, 0, 250, 200);
        colorPanel.setBackground(Color.BLUE);

        // Button actions
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.RED);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.BLUE);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.GREEN);
            }
        });

        frame.add(buttonPanel);
        frame.add(colorPanel);
        frame.setVisible(true);
    }
}
