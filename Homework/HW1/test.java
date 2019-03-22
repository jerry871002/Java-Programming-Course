import javax.swing.JOptionPane;

public class test {
    public static void main(String[] args) {
        String extension;
        String filename;

        filename = JOptionPane.showInputDialog("Please input a file name");
        String[] filenameSplit = filename.split("\\.");
        System.out.println(filenameSplit.length);
    }
}
