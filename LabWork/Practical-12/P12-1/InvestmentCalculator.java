import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class InvestmentCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Investment Calculator");

        JLabel amountLabel = new JLabel("Amount:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel rateLabel = new JLabel("Interest Rate:");
        JLabel futureLabel = new JLabel("Future Value:");

        JTextField amountField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField rateField = new JTextField();
        JTextField futureField = new JTextField();
        futureField.setEditable(false);
        futureField.setBackground(Color.LIGHT_GRAY); // or awt.Color.LIGHT_GRAY

        JButton calculateBtn = new JButton("Calculate");

        amountLabel.setBounds(30, 30, 100, 30);
        amountField.setBounds(150, 30, 120, 30);

        yearLabel.setBounds(30, 70, 100, 30);
        yearField.setBounds(150, 70, 120, 30);

        rateLabel.setBounds(30, 110, 100, 30);
        rateField.setBounds(150, 110, 120, 30);

        futureLabel.setBounds(30, 150, 100, 30);
        futureField.setBounds(150, 150, 120, 30);

        calculateBtn.setBounds(100, 200, 100, 30);

        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    int years = Integer.parseInt(yearField.getText());
                    double rate = Double.parseDouble(rateField.getText());

                    double futureValue = amount * Math.pow(1 + rate / 100, years);
                    futureField.setText(String.format("%.2f", futureValue)); // Or futureField.setText(Double.toString(futureValue));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers");
                }
            }
        });

        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(yearLabel);
        frame.add(yearField);
        frame.add(rateLabel);
        frame.add(rateField);
        frame.add(futureLabel);
        frame.add(futureField);
        frame.add(calculateBtn);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
