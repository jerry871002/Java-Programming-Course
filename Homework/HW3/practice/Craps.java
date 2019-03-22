import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Craps extends JFrame implements ActionListener {
    // constant variables for game status
    final int WON = 0, LOST = 1, CONTINUE = 2;

    boolean firstRoll = true;
    int sumOfDice = 0;
    int myPoint = 0;
    int gameStatus = CONTINUE;

    // graphical interface components
    JLabel die1Label, die2Label, sumLabel, pointLabel, statusLabel;
    JTextField die1Field, die2Field, sumField, pointField;
    JButton rollButton;
    JPanel opPanel, sPanel;

    public Craps() { // set up GUI components
        super("Craps");
        opPanel = new JPanel();
        sPanel = new JPanel();
        add(opPanel, BorderLayout.CENTER);
        add(sPanel, BorderLayout.SOUTH);
        opPanel.setLayout(new FlowLayout());

        // create label and text field for die 1
        die1Label = new JLabel("Die 1");
        opPanel.add(die1Label);
        die1Field = new JTextField(10);
        die1Field.setEditable(false);
        opPanel.add(die1Field);

        // create label and text field for die 2
        die2Label = new JLabel("Die 2");
        opPanel.add(die2Label);
        die2Field = new JTextField(10);
        die2Field.setEditable(false);
        opPanel.add(die2Field);

        // create label and text field for sum
        sumLabel = new JLabel("Sum is");
        opPanel.add(sumLabel);
        sumField = new JTextField(10);
        sumField.setEditable(false);
        opPanel.add(sumField);

        // create label and text field for point
        pointLabel = new JLabel("point is");
        opPanel.add(pointLabel);
        pointField = new JTextField(10);
        pointField.setEditable(false);
        opPanel.add(pointField);

        // create button user clicks to roll dice
        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(this);
        opPanel.add(rollButton);

        statusLabel = new JLabel("Game start");
        sPanel.add(statusLabel);
    }

    // process one roll of dice
    public void actionPerformed(ActionEvent actionEvent) {
        sumOfDice = rollDice();
        if(firstRoll) {
            switch(sumOfDice) {
                // win on first roll
                case 7:
                case 11:
                    gameStatus = WON;
                    pointField.setText("");
                    break;

                // lose in first roll
                case 2:
                case 3:
                case 12:
                    gameStatus = LOST;
                    pointField.setText("");
                    break;

                // remember point
                default:
                    gameStatus = CONTINUE;
                    myPoint = sumOfDice;
                    pointField.setText(Integer.toString(myPoint));
                    firstRoll = false;
                    break;
            }
        } else {
            if(sumOfDice == myPoint)
                gameStatus = WON;
            else if(sumOfDice == 7)
                gameStatus = LOST;
        }
        displayMessage();
    }

    public int rollDice() {
        // pick random die values
        int die1 = 1 + (int)(Math.random() * 6);
        int die2 = 1 + (int)(Math.random() * 6);
        int sum = die1 + die2;

        // display results in textFields
        die1Field.setText(Integer.toString(die1));
        die2Field.setText(Integer.toString(die2));
        sumField.setText(Integer.toString(sum));

        return sum;
    }

    public void displayMessage() {
        if(gameStatus == CONTINUE)
            statusLabel.setText("Roll again");
        else {
            if(gameStatus == WON)
                statusLabel.setText("Player wins. Click Roll Dice to play again.");
            else
                statusLabel.setText("Player loses. Click Roll Dice to play again.");

            firstRoll = true;
        }
    }

    public static void main(String[] args) {
        Craps c1 = new Craps();
        c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c1.setSize(320, 300);
        c1.setVisible(true);
    }
}
