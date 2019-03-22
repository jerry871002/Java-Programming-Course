import javax.swing.JOptionPane;

public class hw2_5_case1 {
    public static void main(String[] args) {
        double x = 0, y = 0, r = 0, theta = 0;

        int option;
        option = Integer.parseInt(JOptionPane.showInputDialog("1. From rectangular form into polar form\n" +
        "2. From polar form into rectangular form\n" +
        "Please choose a function: "));

        if(option == 1) {
            x = Double.parseDouble(JOptionPane.showInputDialog("Please enter x"));
            y = Double.parseDouble(JOptionPane.showInputDialog("Please enter y"));

            r = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
            theta = Math.atan2(y, x) * 180 / Math.PI;
        } else if(option == 2) {
            r = Double.parseDouble(JOptionPane.showInputDialog("Please enter r"));
            theta = Double.parseDouble(JOptionPane.showInputDialog("Please enter theta"));

            x = r * Math.cos(theta * Math.PI / 180);
            y = r * Math.sin(theta * Math.PI / 180);
        }
        JOptionPane.showMessageDialog(null, String.format("(x, y) = (%.2f, %.2f)%n(r, theta) = (%.2f %.2f)%n", x, y, r, theta));
    }
}
