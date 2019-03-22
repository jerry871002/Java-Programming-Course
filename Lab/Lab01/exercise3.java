import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class exercise3 extends Application {
    String[] texts = new String[3];
    int fontSize;
    String style;

    public void init() {
        texts[0] = JOptionPane.showInputDialog("Enter 1st text");
        texts[1] = JOptionPane.showInputDialog("Enter 2nd text");
        texts[2] = JOptionPane.showInputDialog("Enter 3rd text");
        fontSize = Integer.parseInt(JOptionPane.showInputDialog("Enter font size"));
        style = JOptionPane.showInputDialog("Enter the arrangement style(|-/\\)");
    }

    public void start(Stage stage) {
        Text text1 = new Text(texts[0]);
        Text text2 = new Text(texts[1]);
        Text text3 = new Text(texts[2]);

        text1.setFont(Font.font(fontSize));
        text2.setFont(Font.font(fontSize));
        text3.setFont(Font.font(fontSize));

        text1.setFill(Color.RED);
        text2.setFill(Color.BLUE);
        text3.setFill(Color.GREEN);

        if(style.equals("|")) {
            text1.setX(fontSize);
            text1.setY(fontSize);
            text2.setX(fontSize);
            text2.setY(2 * fontSize);
            text3.setX(fontSize);
            text3.setY(3 * fontSize);
        } else if(style.equals("-")) {
            text1.setX(0);
            text1.setY(2 * fontSize);
            text2.setX(fontSize);
            text2.setY(2 * fontSize);
            text3.setX(2 * fontSize);
            text3.setY(2 * fontSize);
        } else if(style.equals("\\")) {
            text1.setX(0);
            text1.setY(fontSize);
            text2.setX(fontSize);
            text2.setY(2 * fontSize);
            text3.setX(2 * fontSize);
            text3.setY(3 * fontSize);
        } else if(style.equals("/")) {
            text1.setX(2 * fontSize);
            text1.setY(fontSize);
            text2.setX(fontSize);
            text2.setY(2 * fontSize);
            text3.setX(0);
            text3.setY(3 * fontSize);
        }

        Group root = new Group(text1, text2, text3); // scene group
        Scene scene = new Scene(root, 3 * fontSize, 3 * fontSize);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
