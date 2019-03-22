import javax.swing.JOptionPane;

public class hw1_1_case1 {
    public static void main(String[] args) {
        int sum = 0, product = 1, smallest, largest;
        double average;
        int nums[] = new int[3];
        String numVal[] = new String[3];

        for(int i = 0; i < 3; i++) {
            numVal[i] = JOptionPane.showInputDialog("Enter an integer:");
            nums[i] = Integer.parseInt(numVal[i]);
            sum += nums[i];
            product *= nums[i];
        }

        average = sum / 3.;

        smallest = nums[0];
        largest = nums[0];
        for(int i = 1; i < 3; i++) {
            if(nums[i] < nums[i-1]) {
                smallest = nums[i];
            } else if(nums[i] > nums[i-1]) {
                largest = nums[i];
            }
        }

        JOptionPane.showMessageDialog(null, "The sum is " + sum + ".\n" +
                                            "The average is " + average + ".\n" +
                                            "The product is " + product + ".\n" +
                                            "The smallest is " + smallest + ".\n" +
                                            "The largest is " + largest + ".\n");

        System.exit(0);
    }
}
