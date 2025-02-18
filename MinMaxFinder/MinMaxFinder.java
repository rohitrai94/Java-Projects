import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinMaxFinder extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton findButton;

    public MinMaxFinder () {
        setTitle("Min & Max Finder");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        inputField = new JTextField();
        findButton = new JButton("Find Min & Max");
        findButton.setBackground(Color.gray);
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findMinMax();
            }
        });

        add(new JLabel("Enter numbers (comma-separated):", SwingConstants.CENTER));
        add(inputField);
        add(findButton);
        add(resultLabel);

        setVisible(true);
    }

    private void findMinMax() {
        try {
            String input = inputField.getText();
            String[] numbers = input.split(",");
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (String num : numbers) {
                int value = Integer.parseInt(num.trim());
                if (value < min) min = value;
                if (value > max) max = value;
            }

            resultLabel.setText("Min: " + min + " | Max: " + max);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MinMaxFinder());
    }
}
