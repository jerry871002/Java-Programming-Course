import java.util.Scanner;

public class practice_command_line {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enetr the radius: ");
        int radius = input.nextInt();

        int diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2.0);

        System.out.printf("Diameter = %d%n", diameter);
        System.out.printf("Circumference = %f%n", circumference);
        System.out.printf("Area = %f%n", area);
    }
}
