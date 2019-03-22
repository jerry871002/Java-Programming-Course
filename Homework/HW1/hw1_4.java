import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class hw1_4 extends Application {
    String extension;

    public void init() {
        String fileName;
        fileName = JOptionPane.showInputDialog("Please input a file name");
        extension = fileName.split("\\.")[1];
    }

    public void start(Stage stage) {
        Text text = new Text("The file extension is " + extension);
        text.setX(50);
        text.setY(50);
        Group root = new Group(text); // scene group
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Enter main, before launch");
        launch(args);
        System.out.println("After launch, end of the main");
    }
}
