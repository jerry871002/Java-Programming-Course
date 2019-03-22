import java.awt.Graphics;
import javax.swing.*;

public class Product2 extends JApplet {
    double mul;

    public void init() {
        String first, second;
        double number1, number2;
        first = JOptionPane.showInputDialog("Enter first real value");
        second = JOptionPane.showInputDialog("Enter second real value");

        number1 = Double.parseDouble(first);
        number2 = Double.parseDouble(second);
        mul = number1 * number2;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(15, 10, 270, 20);
        g.drawString("The product is" + mul, 25, 25);
    }
}
