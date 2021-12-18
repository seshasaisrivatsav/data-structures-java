package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[][] res = zeroMatrix_moreSpace(matrix);
        for (int i=0; i<res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        int[][] matrix2 = {
                {6, 1, 2, 1, 9},
                {3, 0, 5, 2, 11},
                {1, 3, 1, 0, 12},
                {1, 3, 3, 6, 4},
        };
        zeroMatrix_noExtraSpace(matrix2);
        for (int i=0; i<matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }

    /**
     * Approach: rather than using extra space, we use the matrix first row as row array
     *          and first coloulm as column array
     * @param matrix
     */
    public static void zeroMatrix_noExtraSpace(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        // Check if first row is zero
        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i]==0) {
                rowHasZero = true;
                break;
            }
        };

        // check if column has zero
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        // iterate through matrix and store
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify rows based on values in first column
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // nullify cols based on values in first row
        for (int i=1; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                nullifyColumn(matrix, i);
            }
        }

        if(rowHasZero) {
            nullifyRow(matrix,0);
        }
        if(columnHasZero) {
            nullifyColumn(matrix,0);
        }
    }

    static void nullifyRow(int[][] matrix, int row) {
        for (int i=0; i<matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    static void nullifyColumn(int[][] matrix, int col) {
        for (int i=0; i<matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    /**
     * Approach: get pointers when we find an element to be 0
     *          iterate once to make row zero and again to make column zero
     *
     *          We can make an entire array as 0 using Arrays.fill(arr, 0)
     *
     * Time Complexity: O(MxN) ~ O(N2)
     * Space Complexity: O(m+n)
     * @param matrix
     * @return
     */
    public static int[][] zeroMatrix_moreSpace(int[][] matrix) {
        ArrayList<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // STEP 1: Make the ROWS as zeroes
        rows.forEach((row) -> {
            Arrays.fill(matrix[row], 0); // NOTE Arrays.fill will fill the row with zero
        });

        cols.forEach((col) -> {
            // STEP 2: Make columns as zeroes
            for (int i=0; i<matrix.length; i++) {
                matrix[i][col] = 0;
            };
        });

        return matrix;
    }
}
