package sortingAndSearching;

import java.util.Arrays;

/**
 * Given three sorted arrays, merge them
 */
public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 9, 13, 16, 17 };
        int[] arr2 = { 2, 5, 8, 10, 12, 15, 19 };
        int[] arr3 = { 3, 6, 7, 11, 14, 18, 20 };
        System.out.println("Expected: [1, 2, 3...20] Actual: " + Arrays.toString(mergeThreeSortedArrays_threePointers(arr1, arr2, arr3)));
        System.out.println("Expected: [1, 2, 3...20] Actual: " + Arrays.toString(mergeThreeSortedArrays_twoAtATime(arr1, arr2, arr3)));

        int[] arr4 = {1, 2, 3};
        int[] arr5 = {4};
        int[] arr6 = {5, 6, 7, 8};
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8] Actual: " + Arrays.toString(mergeThreeSortedArrays_threePointers(arr4, arr5, arr6)));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8] Actual: " + Arrays.toString(mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6)));

        int[] arr7 = {1, 5, 6};
        int[] arr8 = {};
        int[] arr9 = {2, 3, 4};
        System.out.println("Expected: [1, 2, 3, 4, 5, 6] Actual: " + Arrays.toString(mergeThreeSortedArrays_threePointers(arr7, arr8, arr9)));
    }

    /* **********  vvvv  Solution A: with 3 pointers vvvv  ********************/
    /**
     * Time Complexity: O(arr1.length + arr2.length + arr3.length)
     * Space Complexity: O(1) - assuming we don't take result space into consideration
     * @param arr1 int[] sorted arr1
     * @param arr2 int[] sorted arr2
     * @param arr3 int[] sorted arr3
     * @return int[] sorted with above 3
     */
    public static int[] mergeThreeSortedArrays_threePointers(int[] arr1, int[] arr2, int[] arr3) {
        int[] res = new int[arr1.length + arr2.length + arr3.length];
        int i=0; int j=0; int k=0; int p=0;

        // When all 3 elements are present
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // case 1: arr1 has smallest
            if ((arr1[i] < arr2[j]) && (arr1[i] < arr3[k])) {
                res[p] = arr1[i];
                i++;
            } else if ((arr2[j] < arr1[i]) && (arr2[j] < arr3[k])) {
                // case 2: arr 2 has smallest
                res[p] = arr2[j];
                j++;
            } else {
                // case 3: arr3 has smallest
                res[p] = arr3[k];
                k++;
            }
            p++;
        }

        // When elements are present in 1, 2
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr1[j]) {
                res[p] = arr1[i];
                i++;
            } else {
                res[p] = arr2[j];
                j++;
            }
            p++;
        }

        // When elements are present in 2, 3
        while (j < arr2.length && k < arr3.length) {
            if (arr2[j] < arr3[k]) {
                res[p] = arr2[j];
                j++;
            } else {
                res[p] = arr3[k];
                k++;
            }
            p++;
        }

        // when elements are present in 1 3
        while (i < arr1.length && k < arr3.length) {
            if (arr1[i] < arr3[k]) {
                res[p] = arr1[i];
                i++;
            } else {
                res[p] = arr3[k];
                k++;
            }
            p++;
        }
        // When elements are present in 1
        while (i < arr1.length) {
            res[p] = arr1[i];
            i++;
            p++;
        }
        // When elements are present in 2
        while (j < arr2.length) {
            res[p] = arr2[j];
            j++;
            p++;
        }
        // When elements are present in 3
        while (k < arr3.length) {
            res[p] = arr3[k];
            k++;
            p++;
        }

        return res;
    }
    //***********  ^^^^  Solution A: with 3 pointers ^^^^  ********************/


    //***********  vvvv  Solution B: merge 2 at a time vvvvv  ********************/

    /**
     * Time Complexity: O(n1 + n2 + n3)
     * Space Complexity: O(n1+n2) - since we don't consider result size and we use n1+n2 for first merge
     * @param arr1 int[] sorted arr1
     * @param arr2 int[] sorted arr2
     * @param arr3 int[] sorted arr3
     * @return int[] sorted
     */
    public static int[] mergeThreeSortedArrays_twoAtATime(int[] arr1, int[] arr2, int[] arr3) {
        int[] mergetwo = mergeTwoSorted(arr1, arr2);
        return mergeTwoSorted(mergetwo, arr3);
    }

    /**
     * Sort two
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] mergeTwoSorted(int[] arr1, int[] arr2) {
        int i=0; int j=0;
        int[] res = new int[arr1.length + arr2.length];
        int k=0;
        while (i <arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            res[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            res[k] = arr2[j];
            j++;
            k++;
        }
        return res;
    }

    //***********  ^^^^  Solution B: merge 2 at a time ^^^^^  ********************/
}
