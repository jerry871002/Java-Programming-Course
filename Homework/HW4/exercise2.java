import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class exercise2 extends JFrame implements ActionListener {
    JLabel[] seats;
    boolean[] avaiable;
    JButton request;
    boolean firstFull = false;
    boolean economyFull = false;

    public exercise2() {
        super("Airline Reservation System");

        seats = new JLabel[10];
        avaiable = new boolean[10];
        request = new JButton("A seat!");
        request.addActionListener(this);

        for(int i = 0; i < 10; i++) {
            avaiable[i] = true;
            seats[i] = new JLabel();
            seats[i].setOpaque(true);
            seats[i].setBackground(Color.GREEN);
        }

        setLayout(new GridLayout(2, 12));
        add(new JLabel("Seat", SwingConstants.CENTER));
        add(new JLabel("1", SwingConstants.CENTER));
        add(new JLabel("2", SwingConstants.CENTER));
        add(new JLabel("3", SwingConstants.CENTER));
        add(new JLabel("4", SwingConstants.CENTER));
        add(new JLabel("5", SwingConstants.CENTER));
        add(new JLabel("6", SwingConstants.CENTER));
        add(new JLabel("7", SwingConstants.CENTER));
        add(new JLabel("8", SwingConstants.CENTER));
        add(new JLabel("9", SwingConstants.CENTER));
        add(new JLabel("10", SwingConstants.CENTER));
        add(request);
        add(new JLabel());
        for(int i = 0; i < 10; i++)
            add(seats[i]);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = JOptionPane.showInputDialog("Please type 1 for First Class and type 2 for Economy.");
        int option = Integer.parseInt(input);

        requestSeat(option);
    }

    void requestSeat(int option) {
        if(firstFull && economyFull)
            JOptionPane.showMessageDialog(this, "Next flight leave in 3 hours");

        if(option == 1) {
            if(firstFull) {
                int choice = JOptionPane.showConfirmDialog(this, "No more seat in First Class, how about Ecomomy Class?", "Seat sold out!!", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION)
                    requestSeat(2);
                else
                    JOptionPane.showMessageDialog(this, "Next flight leave in 3 hours");
            } else {
                for(int i = 0; i < 5; i++) {
                    if(avaiable[i]) {
                        JOptionPane.showMessageDialog(this, String.format("Your seat number is %d in First Class", i+1));
                        avaiable[i] = false;
                        seats[i].setBackground(Color.RED);
                        checkFull();
                        break;
                    }
                }
            }
        } else if (option == 2) {
            if(economyFull) {
                int choice = JOptionPane.showConfirmDialog(this, "No more seat in Economy Class, how about First Class?", "Seat sold out!!", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION)
                    requestSeat(1);
                else
                    JOptionPane.showMessageDialog(this, "Next flight leave in 3 hours");
            } else {
                for(int i = 5; i < 10; i++) {
                    if(avaiable[i]) {
                        JOptionPane.showMessageDialog(this, String.format("Your seat number is %d in Economy Class", i+1));
                        avaiable[i] = false;
                        seats[i].setBackground(Color.RED);
                        checkFull();
                        break;
                    }
                }
            }
        }
    }

    void checkFull() {
        if(!avaiable[4])
            firstFull = true;
        if(!avaiable[9])
            economyFull = true;
    }

    public static void main(String[] args) {
        exercise2 f = new exercise2();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(5000, 150);
        f.setVisible(true);
    }
}
