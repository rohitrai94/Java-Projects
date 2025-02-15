  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class BinaryDecimalConverter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConverterFrame());
    }
}

class ConverterFrame extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;
    private JRadioButton binaryToDecimal;
    private JRadioButton decimalToBinary;

    public ConverterFrame() {
        setTitle("Binary & Decimal Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        inputField = new JTextField();
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        binaryToDecimal = new JRadioButton("Binary to Decimal", true);
        decimalToBinary = new JRadioButton("Decimal to Binary");

        ButtonGroup group = new ButtonGroup();
        group.add(binaryToDecimal);
        group.add(decimalToBinary);

        convertButton.addActionListener(new ConvertAction());

        add(new JLabel("Enter Number:", SwingConstants.CENTER));
        add(inputField);
        add(binaryToDecimal);
        add(decimalToBinary);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }

    private class ConvertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            try {
                if (binaryToDecimal.isSelected()) {
                    int decimal = Integer.parseInt(input, 2);
                    resultLabel.setText("Decimal: " + decimal);
                } else {
                    int decimal = Integer.parseInt(input);
                    resultLabel.setText("Binary: " + Integer.toBinaryString(decimal));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input");
            }
        }
    }
}
