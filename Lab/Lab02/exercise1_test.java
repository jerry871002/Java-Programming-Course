import javax.swing.JFrame;

public class exercise1_test {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exercise1 panel = new exercise1();
        application.add(panel);

        application.setSize(250, 250);
        application.setVisible(true);
    }
}
