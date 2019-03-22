import javax.swing.JFrame;

public class hw2_4_test {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hw2_4 panel = new hw2_4();
        application.add(panel);

        application.setSize(250, 250);
        application.setVisible(true);
    }

}
