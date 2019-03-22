import javax.swing.JOptionPane;

public class Product1 {
    public static void main(String[] args) {
        int x, y, result;
        String xVal, yVal;

        xVal = JOptionPane.showInputDialog("Enter first integer:");
        yVal = JOptionPane.showInputDialog("Enter second integer:");

        x = Integer.parseInt(xVal);
        y = Integer.parseInt(yVal);
        result = x * y;
        JOptionPane.showMessageDialog(null, "The product is" + result);

        System.exit(0);
    }
}
