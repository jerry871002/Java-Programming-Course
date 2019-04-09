import java.util.Scanner;

public class hw4_1 {
    static int size;
    static int[][] pascalTri;

    public static void main(String[] args) {
        System.out.print("Please a number: ");
        Scanner input = new Scanner(System.in);
        size = input.nextInt();

        pascalTri = new int[size][];
        for(int i = 1; i <= size; i++) {
            pascalTri[i-1] = new int[i];
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 | j == i)
                    pascalTri[i][j] = 1;
                else
                    pascalTri[i][j] = pascalTri[i-1][j-1] + pascalTri[i-1][j];
            }
        }

        for(int[] row: pascalTri) {
            for(int item: row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
