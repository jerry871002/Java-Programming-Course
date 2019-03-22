import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // draw a line from the upper-left to the lower-right
        g.drawLine(0, 0, width, height);
        // draw a line from the lower-left to the upper-right
        g.drawLine(0, height, width, 0);        
    }

}
