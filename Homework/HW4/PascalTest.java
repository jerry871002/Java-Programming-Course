import javax.swing.JFrame;
import java.awt.*;

public class PascalTest{
	public static void main(String[] args){
		Pascal e=new Pascal();
		e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e.setPreferredSize(new Dimension(214, 327));
		e.setVisible(true);
		e.pack();
		e.setLocationByPlatform(false);
	}
}