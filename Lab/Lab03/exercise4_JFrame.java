import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise4_JFrame extends JFrame implements ActionListener {
    int size, degree, order;
    String[] color = new String[5];
    exercise4_JPanel panel = new exercise4_JPanel();
    JTextField textField = new JTextField();

    public exercise4_JFrame() {
        add(panel);
        add(textField, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(500, 500));
        pack();

        textField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        String[] inputSplit = input.split(" ");

        size = Integer.parseInt(inputSplit[0]);
        degree = Integer.parseInt(inputSplit[6]);
        order = Integer.parseInt(inputSplit[7]);

        for(int i = 1; i <= 5; i++)
            color[i-1] = inputSplit[i];

        panel.send(size, degree, order, color);

        panel.setPreferredSize(new Dimension(size, size));
        pack();

        panel.repaint();
    }
}
