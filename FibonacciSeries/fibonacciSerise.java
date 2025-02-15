package FibonacciSeries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fibonacciSerise extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton generateButton;

    public fibonacciSerise() {
        setTitle("Fibonacci Series Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        inputField = new JTextField();
        generateButton = new JButton("Generate Fibonacci Series");

        panel.add(new JLabel("Enter number of terms:"));
        panel.add(inputField);
        add(panel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(generateButton, BorderLayout.SOUTH);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateFibonacci();
            }
        });

        setVisible(true);
    }

    private void generateFibonacci() {
        resultArea.setText("");  // Clear previous output
        try {
            int n = Integer.parseInt(inputField.getText());
            if (n <= 0) {
                resultArea.setText("Please enter a positive number.");
                return;
            }

            StringBuilder series = new StringBuilder();
            int first = 0, second = 1;
            for (int i = 0; i < n; i++) {
                series.append(first).append(" ");
                int next = first + second;
                first = second;
                second = next;
            }
            resultArea.setText(series.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new fibonacciSerise());
    }
}
