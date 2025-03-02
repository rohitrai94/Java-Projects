import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollingOfDice extends JFrame {
    private JLabel diceLabel;
    private JButton rollButton;
    private Random random;

    public RollingOfDice() {
        setTitle("Dice Roller");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        random = new Random();

        diceLabel = new JLabel("🎲", SwingConstants.CENTER);
        diceLabel.setFont(new Font("SansSerif", Font.PLAIN, 80));

        rollButton = new JButton("Roll Dice");
        rollButton.setFont(new Font("Arial", Font.BOLD, 16));

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        add(diceLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void rollDice() {
        int diceValue = random.nextInt(6) + 1;
        diceLabel.setText("🎲 " + diceValue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RollingOfDice());
    }
}
