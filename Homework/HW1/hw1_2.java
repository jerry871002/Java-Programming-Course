import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class hw1_2 extends Application {
    int sum = 0, product = 1, smallest, largest;
    double average;

    public void init() {
        int nums[] = new int[3];
        String numVal[] = new String[3];

        for(int i = 0; i < 3; i++) {
            numVal[i] = JOptionPane.showInputDialog("Enter an integer:");
            nums[i] = Integer.parseInt(numVal[i]);
            sum += nums[i];
            product *= nums[i];
        }

        average = sum / 3.;

        smallest = smallest(nums);
        largest = largest(nums);
    }

    public void start(Stage stage) {
        Text text = new Text("The sum is " + sum + ".\n" +
                             "The average is " + average + ".\n" +
                             "The product is " + product + ".\n" +
                             "The smallest is " + smallest + ".\n" +
                             "The largest is " + largest + ".\n");
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

    public static int largest(int[] numArray) {
        int largest = numArray[0];
        for(int i = 1; i < numArray.length; i++) {
            if(numArray[i] > numArray[i-1]) {
                largest = numArray[i];
            }
        }
        return largest;
    }

    public static int smallest(int[] numArray) {
        int smallest= numArray[0];
        for(int i = 1; i < numArray.length; i++) {
            if(numArray[i] < numArray[i-1]) {
                smallest = numArray[i];
            }
        }
        return smallest;
    }
}
