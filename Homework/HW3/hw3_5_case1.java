import java.math.BigInteger;

public class hw3_5_case1 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("987654321098765432109876543210");
        BigInteger b = new BigInteger("123456789012345678901234567890");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));
    }
}
