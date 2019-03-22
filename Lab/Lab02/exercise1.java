import javax.swing.*;
import java.awt.*;

public class exercise1 extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int lineNum = (int)(Math.random() * 90) + 10;
        int colorR = (int)(Math.random() * 256);
        int colorG = (int)(Math.random() * 256);
        int colorB = (int)(Math.random() * 256);

        int width = getWidth();
        int height = getHeight();

        g.drawString(Integer.toString(width), width/2, 20);
        g.drawString(Integer.toString(height), width-30, height/2);

        double diff_x = (double)width / lineNum;
        double diff_y = (double)height / lineNum;

        g.setColor(new Color(colorR, colorG, colorB));
        for(int i = 0; i < lineNum; i++)
            g.drawLine(0, (int)(diff_y*i), (int)(diff_x*i), height);
    }
}
