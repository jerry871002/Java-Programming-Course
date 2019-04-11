import javax.swing.JFrame;
import java.awt.*;
import java.util.Scanner;

public class exercise1_test {
	public static void main(String[] args){
        int level;
        Scanner input = new Scanner(System.in);
        level = input.nextInt();

        JFrame f = new JFrame();
        exercise1 e = new exercise1(level);
        f.add(e);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(200, 300));
		f.setVisible(true);
		f.pack();
		//e.setLocationByPlatform(false);
	}
}
