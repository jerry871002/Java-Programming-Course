import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class exercise3 extends JPanel{
    int x[] = new int[3];
    int y[] = new int[3];
    double r[] = new double[3];
    double center_x, center_y;

    exercise3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input three point(x, y): ");
        for(int i = 0; i < 3; i++) {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
        }

        calculate();

        System.out.printf("The circumcenter of three point is (%d, %d)%n", (int)center_x, (int)center_y);

        System.out.printf("%f %f %f %n", r[0], r[1], r[2]);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        int stroke = (int)(Math.random() * 10) + 1;
        g2.setStroke(new BasicStroke(stroke));

        g.setColor(new Color(0, 0, 255));
        g.drawOval((int)(center_x-r[0]), (int)(center_y-r[0]), (int)(2*r[0]), (int)(2*r[0]));

        g.setColor(new Color(0, 255, 0));
        g.drawRect((int)(center_x-r[0]), (int)(center_y-r[0]), (int)(2*r[0]), (int)(2*r[0]));

        g.setColor(new Color(255, 0, 0));
        int delta = 3;
        for(int i = 0; i < 3; i++) {
            g.drawLine((int)x[i]-delta, (int)y[i]-delta,
                        (int)x[i]+delta, (int)y[i]+delta);
            g.drawLine((int)x[i]-delta, (int)y[i]+delta,
                        (int)x[i]+delta, (int)y[i]-delta);
        }
    }

    public void calculate() {
        double x12 = (x[0] + x[1]) / 2.;
        double y12 = (y[0] + y[1]) / 2.;
        double x13 = (x[0] + x[2]) / 2.;
        double y13 = (y[0] + y[2]) / 2.;

        double m1v = (double)(x[1] - x[0]) / (y[0] - y[1]);
        double m2v = (double)(x[2] - x[0]) / (y[0] - y[2]);

        double c1 = y12 - m1v * x12;
        double c2 = y13 - m2v * x13;

        center_y = (m2v*c1 - m1v*c2) / (m2v-m1v);
        center_x = (center_y - c2) / m2v;

        for(int i = 0; i < 3; i++)
            r[i] = Math.pow(Math.pow(x[i]-center_x, 2) + Math.pow(y[i]-center_y, 2), 0.5);
    }
}
