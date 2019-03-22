import javax.swing.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class Product3 extends Application {
    double mul;

    public void init() {
        String first, second;
        double number1, number2;
        first = JOptionPane.showInputDialog("Enter first real value");
        second = JOptionPane.showInputDialog("Enter second real value");

        number1 = Double.parseDouble(first);
        number2 = Double.parseDouble(second);
        mul = number1 * number2;
    }

    public void start(Stage stage) {
        Text text = new Text("The result is " + mul);
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
