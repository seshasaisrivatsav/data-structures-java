package arraysAndStrings;

import java.util.Arrays;

/**
 * Given an image represented NxN matrix where each element that represents pixel,
 * Rotate the image by 90 degrees
 * PS: Do this in-place
 *
 * NOTES: ![image](https://user-images.githubusercontent.com/19309898/127751865-418eff9f-0a88-4527-89bd-9bdfc5ad4e51.png)
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        System.out.println("BEFORE ROTATION: ");
        for (int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println("\nAFTER CLOCKWISE ROTATION: ");
        int[][] res = rotateMatrixClockWise(array);
        for (int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        // PS: rotating clockwise above and anticlock wise here will give original array
        System.out.println("\nAFTER ANTICLOCKWISE ROTATION: ");
        int[][] resAnti = rotateMatrixAnticlockwise(array);
        for (int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(resAnti[i]));
        }
    }


    // O(2n2) - Transpose and swap columns

    /**
     * Time Complexity: O(n2)
     * Space Complexity: O(1)
     * Approach: Transpose + Vertical flip
     *  - Transpose:
     *      Swap i, j and j, i
     *      Where i goes from 0 to N, j goes from 0 to i
     *  - Vertical flip
     *      Swap i, j and i, N-j-1
     *      Where i goes from 0 to N, j goes from 0 to N/2
     * Notes: ![image](https://user-images.githubusercontent.com/19309898/127751865-418eff9f-0a88-4527-89bd-9bdfc5ad4e51.png)
     * Rotates the array by 90 degrees clockwise
     * @param array
     * @return array after rotation
     */
    public static int[][] rotateMatrixClockWise(int[][] array) {
        // STEP 1: Transpose the given matrix
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        // STEP 2: Vertical flip the matrix
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length/2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][array.length-j-1];
                array[i][array.length-j-1] = temp;
            }
        }
        return array;
    }

    /**
     * Approach: Similar to right rotate, but here we just need to
     * Transpose + Horizontal flip
     * @param array 2D array
     * @return 2D array / matrix rotated left
     */
    public static int[][] rotateMatrixAnticlockwise(int[][] array) {
        // STEP 1: Transpose the given matrix
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        for (int i=0; i<array.length/2; i++) {
            for (int j=0; j<array.length; j++) {
                int temp = array[i][j];
                array[i][j] = array[array.length-i-1][j];
                array[array.length-i-1][j] = temp;
            }
        }
        return array;
    }
}
