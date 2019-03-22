import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class exercise2 extends JPanel{
    int initSize;

    exercise2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input window size: ");
        initSize = input.nextInt();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int colorR1 = (int)(Math.random() * 256);
        int colorG1 = (int)(Math.random() * 256);
        int colorB1 = (int)(Math.random() * 256);
        int colorR2 = (int)(Math.random() * 256);
        int colorG2 = (int)(Math.random() * 256);
        int colorB2 = (int)(Math.random() * 256);

        int width = getWidth();
        int height = getHeight();

        g.drawString(Integer.toString(width), width/2, 20);
        g.drawString(Integer.toString(height), width-30, height/2);

        if(width == height) {
            g.setColor(new Color(colorR1, colorG1, colorB1));
            g.drawOval((int)(0.172*width), 0,
                        (int)(0.828*width), (int)(0.828*width));
            g.setColor(new Color(colorR2, colorG2, colorB2));
            g.drawOval(0, -1*width, 2*width, 2*width);
        }
    }
}
