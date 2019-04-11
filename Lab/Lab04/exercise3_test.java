import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class exercise3_test extends JFrame implements ActionListener {
    JPanel controlButtons;
    JButton red, green, blue, width1, width2, width3;
    String color, width;
    JLabel hint;
    exercise3 paintPanel;

    public exercise3_test() {
        super("A simple paint program");

        paintPanel = new exercise3();
        // paintPanel.setOpaque(false);
        add(paintPanel, BorderLayout.CENTER);

        controlButtons = new JPanel();
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        width1 = new JButton("Width 1");
        width2 = new JButton("Width 2");
        width3 = new JButton("Width 3");
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        width1.addActionListener(this);
        width2.addActionListener(this);
        width3.addActionListener(this);

        controlButtons.add(new JLabel("*"));
        controlButtons.add(red);
        controlButtons.add(green);
        controlButtons.add(blue);
        controlButtons.add(new JLabel("*"));
        controlButtons.add(width1);
        controlButtons.add(width2);
        controlButtons.add(width3);
        controlButtons.add(new JLabel("*"));
        add(controlButtons, BorderLayout.NORTH);

        color = "Red";
        paintPanel.setColor(1);
        width = "Normal";
        paintPanel.setWidth(2);
        hint = new JLabel(String.format("Current color: %s, Current width: %s", color, width));
        add(hint, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == red) {
            color = "Red";
            paintPanel.setColor(1);
        } else if(e.getSource() == green) {
            color = "Green";
            paintPanel.setColor(2);
        } else if(e.getSource() == blue) {
            color = "Blue";
            paintPanel.setColor(3);
        } else if(e.getSource() == width1) {
            width = "Thin";
            paintPanel.setWidth(1);
        } else if(e.getSource() == width2){
            width = "Normal";
            paintPanel.setWidth(2);
        } else if(e.getSource() == width3){
            width = "Thick";
            paintPanel.setWidth(3);
        }
        hint.setText(String.format("Current color: %s, Current width: %s", color, width));
    }

    public static void main(String[] args) {
        exercise3_test app = new exercise3_test();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(800, 800);
        app.setVisible(true);
    }
}
