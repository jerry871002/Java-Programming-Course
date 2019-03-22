import javax.swing.JOptionPane;

public class exercise1 {
    public static void main(String[] args) {
        String filename, extension;
        filename = JOptionPane.showInputDialog("Enter a filename with filename extension");

        extension = getFileExtension(filename);
        JOptionPane.showMessageDialog(null, "The filename extension is " + extension);

        System.exit(0);
    }

    static String getFileExtension(String filename) {
        String filenameSplit[] =  filename.split("\\.");
        return filenameSplit[filenameSplit.length-1];
    }
}
