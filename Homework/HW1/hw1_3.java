import javax.swing.JOptionPane;

public class hw1_3 {
    static int change;

    public static void main(String[] args) {
        int price;
        int quarterCnt, dimeCnt, nickelCnt, pennyCnt;
        String priceVal;

        priceVal = JOptionPane.showInputDialog("Enter price of item\n" +
        "(from 25 cents to one dollar, in 5-cent increments)");

        price = Integer.parseInt(priceVal);
        change = 100 - price;

        quarterCnt = countCoin(25);
        dimeCnt = countCoin(10);
        nickelCnt = countCoin(5);
        pennyCnt = countCoin(1);

        String message = "You bought an item for " + price +
                         " cents and gave me one dollar.\n" +
                         "So your change is\n";

        if(quarterCnt != 0)
            message += (quarterCnt + " quarter(s)\n");
        if(dimeCnt != 0)
            message += (dimeCnt + " dime(s)\n");
        if(nickelCnt != 0)
            message += (nickelCnt + " nickel(s)\n");
        if(pennyCnt != 0)
            message += (pennyCnt + " penny(s)\n");

        JOptionPane.showMessageDialog(null, message);

        System.exit(0);
    }

    public static int countCoin(int perCoin) {
        int coins = 0;
        while(change >= perCoin) {
            coins += 1;
            change -= perCoin;
        }
        return coins;
    }
}
