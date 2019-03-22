import javax.swing.*;
import java.awt.Graphics;

public class hw2_4 extends JPanel{
    int option, lineNum;

    hw2_4() {
        option = Integer.parseInt(JOptionPane.showInputDialog("Enter an option(1/2/3/4)"));
        lineNum = Integer.parseInt(JOptionPane.showInputDialog("Enter line numbers"));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int diff_x = width / lineNum;
        int diff_y = height / lineNum;

        for(int i = 0; i < lineNum; i++) {
            switch (option) {
                case 1:
                    g.drawLine(0, 0, diff_x*i, height-diff_y*i);
                    break;
                case 2:
                    g.drawLine(0, 0, diff_x*i, height-diff_y*i);
                    g.drawLine(width, 0, diff_x*i, diff_y*i);
                    g.drawLine(0, height, diff_x*i, diff_y*i);
                    g.drawLine(width, height, diff_x*i, height-diff_y*i);
                    break;
                case 3:
                    g.drawLine(0, diff_y*i, diff_x*i, height);
                    break;
                case 4:
                    g.drawLine(0, diff_y*i, diff_x*i, height);
                    g.drawLine(diff_x*i, height, width, height-diff_y*i);
                    g.drawLine(diff_x*i, 0, width, diff_y*i);
                    g.drawLine(diff_x*i, 0, 0, height-diff_y*i);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hw2_4 panel = new hw2_4();
        application.add(panel);

        application.setSize(250, 250);
        application.setVisible(true);
    }
}
