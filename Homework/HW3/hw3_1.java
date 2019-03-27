import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class hw3_1 extends JFrame implements ActionListener {
    int answer, high, low;
    boolean correct = false;

    // graphical interface components
    JLabel promptLabel, statusLabel;
    JTextField guessField;

    public hw3_1() { // set up GUI components
        super("Guess a number");
        promptLabel = new JLabel();
        add(promptLabel, BorderLayout.NORTH);
        guessField = new JTextField();
        add(guessField, BorderLayout.CENTER);
        guessField.addActionListener(this);
        statusLabel = new JLabel();
        add(statusLabel, BorderLayout.SOUTH);

        newGame();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int guess = Integer.parseInt(guessField.getText());

        if(correct) {
            correct = false;
            newGame();
            return;
        }

        if(guess > answer) {
            high = guess;
            statusLabel.setText("Too high. Try again.");
            promptLabel.setText(String.format("Guess a number between %d and %d", low, high));
            guessField.setText("");
        } else if(guess < answer) {
            low = guess;
            statusLabel.setText("Too low. Try again.");
            promptLabel.setText(String.format("Guess a number between %d and %d", low, high));
            guessField.setText("");
        } else {
            statusLabel.setText("Congradulations. You guessed the number!!!");
            guessField.setText("");
            correct = true;
        }
    }

    public void newGame() {
        answer = (int)(Math.random() * 999) + 1;
        high = 1000;
        low = 1;
        promptLabel.setText(String.format("Guess a number between %d and %d", low, high));
        statusLabel.setText("");
    }

    public static void main(String[] args) {
        hw3_1 c1 = new hw3_1();
        c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c1.setSize(320, 300);
        c1.setVisible(true);
    }
}
