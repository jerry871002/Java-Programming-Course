import javax.swing.JFrame;

public class exercise3_test {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exercise3 panel = new exercise3();

        application.setSize(350, 350);
        application.add(panel);
        application.setVisible(true);
    }
}
