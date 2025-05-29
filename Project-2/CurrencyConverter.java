import javax.swing.*;
import java.awt.event.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency Converter");

        JLabel label1 = new JLabel("Amount:");
        label1.setBounds(20, 40, 100, 30);

        JTextField amountField = new JTextField();
        amountField.setBounds(100, 40, 150, 30);

        String[] currencies = {"USD", "INR", "EUR"};
        JComboBox<String> fromBox = new JComboBox<>(currencies);
        fromBox.setBounds(100, 80, 70, 30);

        JComboBox<String> toBox = new JComboBox<>(currencies);
        toBox.setBounds(180, 80, 70, 30);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(100, 130, 150, 30);

        JLabel resultLabel = new JLabel("Converted amount: ");
        resultLabel.setBounds(20, 170, 300, 30);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromBox.getSelectedItem();
                String to = (String) toBox.getSelectedItem();
                double convertedAmount = convertCurrency(amount, from, to);
                resultLabel.setText("Converted amount: " + convertedAmount + " " + to);
            }
        });

        frame.add(label1);
        frame.add(amountField);
        frame.add(fromBox);
        frame.add(toBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static double convertCurrency(double amount, String from, String to) {
        double rate = 1.0;
        if (from.equals("USD") && to.equals("INR")) rate = 83.0;
        else if (from.equals("INR") && to.equals("USD")) rate = 0.012;
        else if (from.equals("USD") && to.equals("EUR")) rate = 0.92;
        else if (from.equals("EUR") && to.equals("USD")) rate = 1.09;
        else if (from.equals("INR") && to.equals("EUR")) rate = 0.011;
        else if (from.equals("EUR") && to.equals("INR")) rate = 89.0;
        else rate = 1.0; // Same currency or unknown case
        return amount * rate;
    }
}
