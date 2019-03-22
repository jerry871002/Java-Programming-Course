import javax.swing.JOptionPane;

public class hw1_1_case2 {
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

        smallest = smallest(nums);
        largest = largest(nums);

        JOptionPane.showMessageDialog(null, "The sum is " + sum + ".\n" +
                                            "The average is " + average + ".\n" +
                                            "The product is " + product + ".\n" +
                                            "The smallest is " + smallest + ".\n" +
                                            "The largest is " + largest + ".\n");

        System.exit(0);
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
