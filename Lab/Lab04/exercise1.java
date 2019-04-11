import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class exercise1 extends JPanel {
    static int[][] pascalTri;
    int level;

	public exercise1(int level){
        setLayout(null);
		makeTri(level);
        this.level = level;
	}

    void makeTri(int size) {
        pascalTri = new int[size][];
        for(int i = 1; i <= size; i++) {
            pascalTri[i-1] = new int[i];
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 | j == i)
                    pascalTri[i][j] = 1;
                else
                    pascalTri[i][j] = pascalTri[i-1][j-1] + pascalTri[i-1][j];
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();

        int width = getWidth();
        int height = getHeight();

        int heightPerLevel = height / level;
        int widthPerElement = width / level;

        int numOfElements = (1 + level) * level / 2;
        JLabel[] labels = new JLabel[numOfElements];

        int i = 0, j = 0;
        for(int[] row: pascalTri) {
            j = 0;
            for(int item: row) {
                labels[i] = new JLabel(String.valueOf(item), SwingConstants.CENTER);

                labels[i].setSize(widthPerElement, heightPerLevel);
                labels[i].setLocation((int)((0.5*(level-1-i)+j)*widthPerElement),
                                      (level-1-i)*heightPerLevel);
                                      
                add(labels[i]);
                j++;
            }
            i++;
        }
    }
}
