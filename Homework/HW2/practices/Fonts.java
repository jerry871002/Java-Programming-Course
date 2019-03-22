import java.awt.*;
import javax.swing.*;

public class Fonts extends JFrame {
    public Fonts() {
        super("Using fonts");
        setSize(500, 700);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif 12 point bold.", 20, 50);
        g.setFont(new Font("Courier", Font.ITALIC, 24));
        g.drawString("Courier 24 point italic.", 20, 100);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("SansSerif 14 point plain.", 20, 150);
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
        g.drawString(g.getFont().getName() + " " + g.getFont().getSize() + " point bold italic.", 20, 200);
        g.setColor(Color.BLUE);
        g.setFont(new Font("新細明體", Font.BOLD + Font.ITALIC, 24));
        g.drawString(g.getFont().getName(), 20, 250);
    }

    public static void main(String[] args) {
        Fonts application = new Fonts();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
