import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class Pascal extends JFrame{
	private final JTextField sizeField;
	private final JTextArea drawText;
	private final JLabel sizeLabel;
	private final JPanel drawPanel,sizePanel;
	private int number = 0;

	public Pascal(){
		super("Pascal Triangle");
		setLayout(new FlowLayout());

		drawPanel = new JPanel();
		drawPanel.setBackground(Color.white);
		drawText = new JTextArea();
		drawText.setEditable(false);
		drawPanel.add(drawText);
		add(drawPanel,BorderLayout.CENTER);

		sizePanel = new JPanel();

		sizeField = new JTextField(10);
		sizeField.setEditable(true);
		TextFieldHandler handler = new TextFieldHandler();
		sizeField.addActionListener(handler);

		sizeLabel =new JLabel("Enter Size");

		sizePanel.add(sizeLabel);
		sizePanel.add(sizeField);

		add(sizePanel,BorderLayout.NORTH);
	}

	private class TextFieldHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent){
			String str=sizeField.getText();
			number=Integer.parseInt(str);
			//redrawPascal(number);

			int[][] array=new int[number][number];

			drawText.setText("");

			String tmp="";
			for(int[] row:array){
				for(int col:row){
					row[col]=0;
				}
			}

			array[0][0]=1;

			for(int i=0;i<number;i++){
				tmp="";
				for(int j=0;j<number;j++){
					if(i==0);
					else if(j==0) array[i][j]=array[i-1][j];
					else array[i][j]=array[i-1][j]+array[i-1][j-1];
					if(array[i][j]==0) continue;
					tmp=tmp+" "+String.valueOf(array[i][j]);
				}
				drawText.append(tmp+"\n");
			}
		}
	}
}
