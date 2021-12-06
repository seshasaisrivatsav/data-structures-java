package arraysAndStrings;

import java.util.Arrays;

/**
 * Given an MxN matrix, if an element is 0, make the entire row and column zero
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 12, 13, 14},
                {10, 15, 14, 11},
                {10, 15, 19, 22},
        };
        int[][] res = zeroMatrix(matrix);
        for (int i=0; i<res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * Approach: get pointers when we find an element to be 0
     *          iterate once to make row zero and again to make column zero
     *
     *          We can make an entire array as 0 using Arrays.fill(arr, 0)
     *
     * Time Complexity: O(MxN) ~ O(N2)
     * Space Complexity: O(1)
     * @param matrix
     * @return
     */
    public static int[][] zeroMatrix(int[][] matrix) {
        int row=-1, col=-1;
        // O(n^2)
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        // STEP 1: Make the ROWS as zeroes
        Arrays.fill(matrix[row], 0); // NOTE Arrays.fill will fill the row with zero
        /*
        for (int i=0;i<matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
         */

        // STEP 2: Make columns as zeroes
        for (int i=0; i<matrix.length; i++) {
            matrix[i][col] = 0;
        };
        return matrix;
    }
}
