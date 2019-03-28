import javax.swing.*;
import java.awt.*;

class exercise3_JPanel extends JPanel {
    int size, degree;
    String[] colorStr = new String[5];
    Color[] color = new Color[5];

    public exercise3_JPanel() {
        // Do nothing
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCircle(g, size/2, size/2, size/4);
        drawMark(g, size/2, size/2, size/4);
    }

    // draw circle
    public void drawCircle(Graphics g, double x, double y, double radius) {
        g.setColor(color[0]);
        g.drawOval((int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius));
    }

    // draw mark
    public void drawMark(Graphics g, double x, double y, double radius) {
        int delta = 5;
        double radian = degree * Math.PI / 180;
        double sin = Math.sin(radian);
        double cos = Math.cos(radian);

        g.setColor(color[1]);
        drawCross(g, x+radius*cos, y-radius*sin, delta);
        g.setColor(color[2]);
        drawCross(g, x-radius*sin, y-radius*cos, delta);
        g.setColor(color[3]);
        drawCross(g, x-radius*cos, y+radius*sin, delta);
        g.setColor(color[4]);
        drawCross(g, x+radius*sin, y+radius*cos, delta);
    }

    public void drawCross(Graphics g, double x, double y, int delta) {
        g.drawLine((int)(x-delta), (int)(y-delta), (int)(x+delta), (int)(y+delta));
        g.drawLine((int)(x-delta), (int)(y+delta), (int)(x+delta), (int)(y-delta));
    }

    public void send(int size, int degree, String[] color) {
        this.size = size;
        this.degree = degree;
        this.colorStr = color;

        for(int i = 0; i < 5; i++) {
            try {
                this.color[i] = (Color)Color.class.getField(colorStr[i]).get(null);
            } catch (Exception e) {
                this.color[i] = null; // Not defined
            }
        }
    }
}
