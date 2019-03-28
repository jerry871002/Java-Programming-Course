import java.math.BigInteger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise1 extends JFrame implements ActionListener {
    JTextField numField1 = new JTextField(10);
    JTextField numField2 = new JTextField(10);
    JTextField ansField = new JTextField(20);
    JButton mul = new JButton("Multiplication");
    JButton div = new JButton("Division");

    public exercise1() {
        JPanel numPanel = new JPanel(new GridLayout(2, 1));
        numPanel.add(numField1);
        numPanel.add(numField2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mul);
        buttonPanel.add(div);

        JPanel ansPanel = new JPanel();
        ansPanel.add(ansField);

        setLayout(new GridLayout(3, 1));
        add(numPanel);
        add(buttonPanel);
        add(ansPanel);

        mul.addActionListener(this);
        div.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BigInteger num1 = new BigInteger(numField1.getText());
        BigInteger num2 = new BigInteger(numField2.getText());
        BigInteger ans = new BigInteger("0");

        if(e.getSource() == mul) {
            ans = num1.multiply(num2);
        } else if(e.getSource() == div) {
            if(num2.equals(new BigInteger("0"))) {
                JOptionPane.showMessageDialog(null, "The divisor can not be zero!!");
                return;
            }
            ans = num1.divide(num2);
        }
        ansField.setText(ans.toString());
    }
}
