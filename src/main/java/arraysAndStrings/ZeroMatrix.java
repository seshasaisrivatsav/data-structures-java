package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">...</a>
 *
 * Given an MxN matrix, if an element is 0, make the entire row and column zero
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 12, 13, 14},
                {10, 15, 14, 11},
                {10, 15, 19, 22},
        };
        int[][] res = zeroMatrix_moreSpace(matrix);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

        int[][] matrix2 = {
                {6, 1, 2, 1, 9},
                {3, 0, 5, 2, 11},
                {1, 3, 1, 0, 12},
                {1, 3, 3, 6, 4},
        };
        zeroMatrix_noExtraSpace(matrix2);
        System.out.println("----------------");
        for (int[] ints : matrix2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * Approach: rather than using extra space, we use the matrix first row as row array
     *          and first column as column array
     * Space Complexity: O(MN)
     * Time Complexity: O(1)
     *
     * @param matrix int[][]
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

        // Iterate through matrix and check for zero in remaining matrix and store in first row and col
        // Note: Both pointers run from 1 to length
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify cols based on values in first row (order of nullification of rows or columns doesn't matter)
        for (int i=1; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                nullifyColumn(matrix, i);
            }
        }

        // nullify rows based on values in first column (order of nullification of rows or columns doesn't matter)
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
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
        Arrays.fill(matrix[row], 0);
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
     * @param matrix int[]
     * @return int[][] matrix
     */
    public static int[][] zeroMatrix_moreSpace(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
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
