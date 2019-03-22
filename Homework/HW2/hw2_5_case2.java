import java.util.Scanner;

public class hw2_5_case2 {
    public static void main(String[] args) {
        double x = 0, y = 0, r = 0, theta = 0;

        int option;
        Scanner input = new Scanner(System.in);
        System.out.println("1. From rectangular form into polar form");
        System.out.println("2. From polar form into rectangular form");
        System.out.print("Please choose a function: ");
        option = input.nextInt();

        if(option == 1) {
            System.out.print("Please enter x and y: ");
            x = input.nextDouble();
            y = input.nextDouble();

            r = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
            theta = Math.atan2(y, x) * 180 / Math.PI;
        } else if(option == 2) {
            System.out.print("Please enter r and theta: ");
            r = input.nextDouble();
            theta = input.nextDouble();

            x = r * Math.cos(theta * Math.PI / 180);
            y = r * Math.sin(theta * Math.PI / 180);
        }
        System.out.printf("(x, y) = (%.2f, %.2f)%n(r, theta) = (%.2f %.2f)%n", x, y, r, theta);
    }
}
