import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class exercise2 extends Application {
    double sum, average, product, smallest, largest;

    public void init() {
        double nums[] = new double[3];
        String numVal[] = new String[3];

        for(int i = 0; i < 3; i++) {
            numVal[i] = JOptionPane.showInputDialog("Enter a number:");
            nums[i] = Double.parseDouble(numVal[i]);
        }

        sum = sum(nums);
        average = average(nums);
        product = product(nums);
        smallest = min(nums);
        largest = max(nums);
    }

    public void start(Stage stage) {
        Text text = new Text("The summation is " + sum + "\n" +
                             "The average is " + average + "\n" +
                             "The product is " + product + "\n" +
                             "The smallest is " + smallest + "\n" +
                             "The largest is " + largest + "\n");
        text.setX(50);
        text.setY(50);
        Group root = new Group(text); // scene group
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static double sum(double[] nums) {
        double sum = 0;
        for(double num : nums) {
            sum += num;
        }
        return sum;
    }

    static double average(double[] nums) {
        double sum = sum(nums);
        return sum / nums.length;
    }

    static double product(double[] nums) {
        double product = 1;
        for(double num : nums) {
            product *= num;
        }
        return product;
    }

    static double min(double[] nums) {
        double min = nums[0];
        for(double num : nums) {
            if(num < min) {
                min = num;
            }
        }
        return min;
    }

    static double max(double[] nums) {
        double max = nums[0];
        for(double num : nums) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }
}
