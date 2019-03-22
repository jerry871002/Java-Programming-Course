import javax.swing.JFrame;

public class DrawPanelTest {
    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel panel = new DrawPanel();
        application.add(panel);

        application.setSize(250, 250);
        application.setVisible(true);
    }
}
