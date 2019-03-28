import java.math.BigInteger;
import java.util.Scanner;

public class hw3_5_case2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = input.nextInt();

        BigInteger factorial = new BigInteger("1");
        for(int i = 1; i <= n; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));

        System.out.println(String.format("factorial(%d) = ", n) + factorial);
    }
}
