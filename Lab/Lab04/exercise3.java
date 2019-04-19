import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.geom.Line2D;

public class exercise3 extends JPanel {
    int color, width;
    Point pre, now;

    public exercise3() {
        addMouseMotionListener(
            new MouseMotionListener(){

                @Override
                public void mouseMoved(MouseEvent e) {
                    now = e.getPoint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    pre = now;
                    now = e.getPoint();
                    exercise3.this.paintComponent(exercise3.this.getGraphics());
                }
            }
        );
    }

    @Override
    public void paintComponent(Graphics g) {
        if(pre == null) {
            super.paintComponent(g);
            return;
        }

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
