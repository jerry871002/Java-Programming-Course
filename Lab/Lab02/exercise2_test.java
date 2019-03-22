import javax.swing.JFrame;

public class exercise2_test {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exercise2 panel = new exercise2();

        application.setSize(panel.initSize, panel.initSize+22);
        application.add(panel);
        application.setVisible(true);
    }
}
