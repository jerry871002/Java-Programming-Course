import javax.swing.JOptionPane;
import java.awt.TextArea;

public class hw2_3 {
    public static void main(String[] args) {
        String first, second, output = "";
        int firstVal, secondVal;

        first = JOptionPane.showInputDialog("Enter first integer:");
        second = JOptionPane.showInputDialog("Enter second integer:");

        firstVal = Integer.parseInt(first);
        secondVal = Integer.parseInt(second);

        if(firstVal == secondVal) {
            output += String.format("%d == %d%n", firstVal, secondVal);
        }
        if(firstVal != secondVal) {
            output += String.format("%d != %d%n", firstVal, secondVal);
        }
        if(firstVal < secondVal) {
            output += String.format("%d < %d%n", firstVal, secondVal);
        }
        if(firstVal > secondVal) {
            output += String.format("%d > %d%n", firstVal, secondVal);
        }
        if(firstVal <= secondVal) {
            output += String.format("%d <= %d%n", firstVal, secondVal);
        }
        if(firstVal >= secondVal) {
            output += String.format("%d >= %d%n", firstVal, secondVal);
        }

        TextArea text1 = new TextArea(output, 2, 1, TextArea.SCROLLBARS_BOTH);
        JOptionPane.showMessageDialog(null, text1);

        System.exit(0);
    }
}
