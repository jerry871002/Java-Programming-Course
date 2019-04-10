import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class hw4_3 extends JFrame implements ActionListener {
    JTextField commandArea;
    JTextField stepNum;
    JButton confirm;
    JPanel toolbar;
    JLabel showArea;
    int[][] floor;
    int facing; // 0: up, 1: right, 2: down, 3: left
    int currentX, currentY;
    boolean penDown;

    public hw4_3() {
        commandArea = new JTextField(5);
        stepNum = new JTextField(5);
        confirm = new JButton("Confirm");
        toolbar = new JPanel();
        showArea = new JLabel("", JLabel.CENTER);
        showArea.setVerticalAlignment(JLabel.TOP);
        showArea.setFont(new Font("Courier", Font.BOLD, 15));
        floor = new int[20][20];

        toolbar.add(commandArea);
        toolbar.add(stepNum);
        toolbar.add(confirm);

        add(toolbar, BorderLayout.NORTH);
        add(showArea, BorderLayout.CENTER);

        confirm.addActionListener(this);

        // Starting at the top left corner, facing right
        facing = 1;
        currentX = 0;
        currentY = 0;
        penDown = false;

        showFloor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showFloor();

        if(e.getSource() == confirm) {
            int command = Integer.parseInt(commandArea.getText());
            int steps = Integer.parseInt(stepNum.getText());
            switch (command) {
                case 1:
                    penDown = false;
                    break;
                case 2:
                    floor[currentY][currentX] = 1;
                    penDown = true;
                    break;
                case 3:
                    facing = (facing + 1) % 4;
                    break;
                case 4:
                    facing = (facing-1 < 0)? 3: facing-1;
                    break;
                case 5:
                    moveForward(steps);
                    break;
                case 6:
                case 9:
            }
        }
        showFloor();
    }

    private void moveForward(int steps) {
        switch (facing) {
            // Up
            case 0:
                if(currentY - steps >= 0) {
                    if(penDown) {
                        for(int i = 1; i <= steps; i++)
                            floor[currentY-i][currentX] = 1;
                    }
                    currentY = currentY - steps;;
                }
                break;
            // Right
            case 1:
                if(currentX + steps < 20) {
                    if(penDown) {
                        for(int i = 1; i <= steps; i++)
                            floor[currentY][currentX+i] = 1;
                    }
                    currentX = currentX + steps;
                }
                break;
            // Down
            case 2:
                if(currentY + steps < 20) {
                    if(penDown) {
                        for(int i = 1; i <= steps; i++)
                            floor[currentY+i][currentX] = 1;
                    }
                    currentY = currentY + steps;
                }
                break;
            // Left
            case 3:
                if(currentX - steps >= 0) {
                    if(penDown) {
                        for(int i = 1; i <= steps; i++)
                            floor[currentY][currentX-i] = 1;
                    }
                    currentX = currentX - steps;
                }
                break;
        }
    }

    private void showFloor() {
        String output = "<html>";
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                if(i == currentY && j == currentX){
                    output += "#";
                    continue;
                }
                if(floor[i][j] == 1)
                    output += "*";
                else
                    output += "0";
            }
            output += "<br>";
        }
        output += "</html>";
        showArea.setText(output);
    }

    public static void main(String[] args) {
        hw4_3 f = new hw4_3();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 450);
        f.setVisible(true);
    }
}
