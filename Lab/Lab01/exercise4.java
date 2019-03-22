import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class exercise4 extends Application {
    String[] texts = new String[3];
    int fontSize;
    String style;

    public void init() {
        String rareInput = JOptionPane.showInputDialog("Enter\n" +
                                                       "1. 1st text\n" +
                                                       "2. 2nd text\n" +
                                                       "3. 3rd text\n" +
                                                       "4. font size\n" +
                                                       "5. arrangement style");
        String[] input = rareInput.split(" ");
        texts[0] = input[0];
        texts[1] = input[1];
        texts[2] = input[2];
        fontSize = Integer.parseInt(input[3]);
        style = input[4];
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
