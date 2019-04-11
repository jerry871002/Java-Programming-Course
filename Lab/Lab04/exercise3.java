import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.geom.Line2D;

public class exercise3 extends JPanel {
    //private final ArrayList<Point> points = new ArrayList<Point>();
    int color, width;
    Point pre, now;

    public exercise3() {
        addMouseMotionListener(
            new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    pre = now;
                    now = e.getPoint();
                    repaint();
                }
            }
        );
    }

    @Override
    public void paintComponent(Graphics g) {
        if(pre == null)
            return;
        //super.paintComponent(g);
        switch (color) {
            case 1: g.setColor(Color.RED); break;
            case 2: g.setColor(Color.GREEN); break;
            case 3: g.setColor(Color.BLUE); break;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5*width));
        g2.drawLine(pre.x, pre.y, now.x, now.y);
    }

    void setColor(int color) {
        this.color = color;
    }

    void setWidth(int width) {
        this.width = width;
    }
}
