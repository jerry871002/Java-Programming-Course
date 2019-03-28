import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Character;

public class exercise2 extends JFrame implements ActionListener {
    JTextField textField = new JTextField(15);
    JButton upper = new JButton("Uppercase");
    JButton lower = new JButton("Lowercase");
    JButton swap = new JButton("Swapcase");

    public exercise2() {
        JPanel textPanel = new JPanel();
        textPanel.add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(upper);
        buttonPanel.add(lower);
        buttonPanel.add(swap);

        setLayout(new GridLayout(2, 1));
        add(textPanel);
        add(buttonPanel);

        upper.addActionListener(this);
        lower.addActionListener(this);
        swap.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        String output = "";
        char c;

        if(e.getSource() == upper) {
            output = text.toUpperCase();
        } else if(e.getSource() == lower) {
            output = text.toLowerCase();
        } else if(e.getSource() == swap) {
            for(int i = 0; i < text.length(); i++) {
                c = text.charAt(i);

                if(Character.isLetter(c)) {
                    if(Character.isLowerCase(c))
                        c = Character.toUpperCase(c);
                    else
                        c = Character.toLowerCase(c);
                }
                output += c;
            }
        }
        textField.setText(output);
    }
}
