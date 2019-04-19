import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class lab4_3 extends JFrame implements MouseMotionListener, ActionListener{
	JPanel tool;
	JButton red, green, blue, width1, width2, width3;
	int posX = -10, posY = -10, posX_ = -10, posY_ = -10;
	int w = 5, color = 1;  //color: 1=red, 2=blue, 3=green
	area panel;

	private class area extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			// super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			if(color == 1)
				g2.setColor(Color.RED);
			else if(color == 2)
				g2.setColor(Color.BLUE);
			else if(color == 3)
				g2.setColor(Color.GREEN);
			g2.setStroke(new BasicStroke(w));
			g2.drawLine(posX, posY, posX_, posY_);
			posX = posX_;
			posY = posY_;
		}

	}

	public lab4_3(){
		super("lab4_3");

		panel = new area();
		panel.setBackground(Color.WHITE);

		tool = new JPanel();
		tool.setLayout(new GridLayout(1, 6));

		red = new JButton("red");
		blue = new JButton("blue");
		green = new JButton("green");
		width1 = new JButton("width 1");
		width2 = new JButton("width 2");
		width3 = new JButton("width 3");
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		width1.addActionListener(this);
		width2.addActionListener(this);
		width3.addActionListener(this);
		tool.add(red);	tool.add(blue);	tool.add(green);
		tool.add(width1);	tool.add(width2);	tool.add(width3);

		add(panel, BorderLayout.CENTER);
		add(tool, BorderLayout.NORTH);

		panel.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e){
		posX_ = e.getX();
		posY_ = e.getY();
		panel.paintComponent(panel.getGraphics());
		// panel.setBackground(Color.GREEN);
		System.out.println(""+posX+", "+posY);
	}

	@Override
	public void mouseMoved(MouseEvent e){
		posX = e.getX();	posY = e.getY();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == red){
			color = 1;
		}
		else if(e.getSource() == blue){
			color = 2;
		}
		else if(e.getSource() == green){
			color = 3;
		}
		else if(e.getSource() == width1){
			w = 5;
		}
		else if(e.getSource() == width2){
			w = 10;
		}
		else if(e.getSource() == width3){
			w = 15;
		}
	}


	public static void main(String args[]){
		lab4_3 f = new lab4_3();
		f.setSize(600, 600);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}