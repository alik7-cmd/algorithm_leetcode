package twodimention;

import java.util.*;

public class TwoDTest {

    public static void print2D(int mat[][]) {
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for(int i = 0; i< R ;i++){
            for(int j = 0; j< C; j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public boolean isThree(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            if(n % i == 0){
                list.add(i);
            }
        }

        return list.size() ==3;

    }

    public int smallestEvenMultiple(int n) {

        return (n%2 ==0) ? n : 2*n;

    }
    public double[] convertTemperature(double celsius) {

        double [] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32.00;

        return res;


    }


    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 0 },
                        { 5, 0, 7, 8 },
                        { 1, 2, 3, 6 } };
        print2D(mat);
        setZeroes(mat);
        System.out.println("--------------> :) ");
        print2D(mat);


    }
}
