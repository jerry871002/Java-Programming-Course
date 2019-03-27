import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class hw3_3 extends JFrame implements ActionListener {
    JTextField textArea;
    JButton uppercase, lowercase;
    JPanel buttons;

    public hw3_3() {
        buttons = new JPanel();
        add(buttons, BorderLayout.SOUTH);
        buttons.setLayout(new FlowLayout());

        uppercase = new JButton("uppercase");
        lowercase = new JButton("lowercase");
        buttons.add(uppercase);
        buttons.add(lowercase);
        uppercase.addActionListener(this);
        lowercase.addActionListener(this);

        textArea = new JTextField();
        add(textArea, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();

        if(e.getSource() == uppercase) {
            text = text.toUpperCase();
            textArea.setText(text);
        } else if(e.getSource() == lowercase) {
            text = text.toLowerCase();
            textArea.setText(text);
        }
    }

    public static void main(String[] args) {
        hw3_3 c1 = new hw3_3();
        c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c1.setSize(320, 300);
        c1.setVisible(true);
    }
}
