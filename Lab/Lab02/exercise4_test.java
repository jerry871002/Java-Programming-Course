import javax.swing.JFrame;

public class exercise4_test {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exercise4 panel = new exercise4();

        application.setSize(350, 350);
        application.add(panel);
        application.setVisible(true);
    }
}
