public class hw3_2 {
    public static void main(String[] args) {
        double x[] = new double[]{-1, -1, 1, 2, 2, 3 ,4 ,4};
        double y[] = new double[]{3, -1, 1, 0.5, -1, 3, 2 ,-0.5};

        int SIZE = x.length;

        int firstPoint = 0, secondPoint = 0;
        double minDistance = Double.MAX_VALUE;
        for(int i = 0; i < SIZE-1; i++) {
            for(int j = i+1; j < SIZE; j++) {
                double distance = Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2);
                if(distance < minDistance) {
                    minDistance = distance;
                    firstPoint = i;
                    secondPoint = j;
                }
            }
        }

        System.out.println(String.format("The points (%.1f, %.1f) and (%.1f, %.1f) are closet to each other.",
        x[firstPoint], y[firstPoint],
        x[secondPoint], y[secondPoint]));
    }
}
