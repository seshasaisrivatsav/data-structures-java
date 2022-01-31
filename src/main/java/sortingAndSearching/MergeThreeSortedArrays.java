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
        System.out.println("Expected: [1, 2, 3...20] Actual: " + Arrays.toString(mergeThreeArrays_myInitialApproach(arr1, arr2, arr3)));

        int[] arr4 = {1, 2, 3};
        int[] arr5 = {4};
        int[] arr6 = {5, 6, 7, 8};
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8] Actual: " + Arrays.toString(mergeThreeArrays_myInitialApproach(arr4, arr5, arr6)));
    }
    public static int[] mergeThreeArrays_modified(int[] arr1, int[] arr2, int[] arr3) {
        int i=0; int j=0; int k=0;

        int resPtr=0;
        int[] res = new int[arr1.length+arr2.length+arr3.length];
        while (i<arr1.length && j<arr2.length && k<arr3.length) {
            // arr1 i has smallest
            if (arr1[i] < arr2[j] && arr1[i] <arr3[k]) {
                res[resPtr] = arr1[i];
                i++;
            }
            // arr2 j has smallest
            else if (arr2[j]<arr1[i] && arr2[j]<arr3[k]) {
                res[resPtr] = arr2[j];
                j++;
            }
            // arr3 k has the smallest
            else {
                res[resPtr] = arr3[k];
                k++;
            }
        }
        while (i<arr1.length && j<arr2.length && k<arr3.length) {
            if (i<arr1.length && j<arr2.length && k<arr3.length) {
                // arr1 i has smallest
                if (arr1[i] < arr2[j] && arr1[i] <arr3[k]) {
                    res[resPtr] = arr1[i];
                    i++;
                }
                // arr2 j has smallest
                else if (arr2[j]<arr1[i] && arr2[j]<arr3[k]) {
                    res[resPtr] = arr2[j];
                    j++;
                }
                else {
                    res[resPtr] = arr3[k];
                    k++;
                }
            } else if (i<arr1.length && j<arr2.length || j<arr2.length && k<arr3.length ||  k<arr3.length && i<arr1.length) {
                if (i<arr1.length && j<arr2.length) {
                    if (arr1[i] < arr2[j]) {
                        res[resPtr] = arr1[i];
                        i++;
                    } else {
                        res[resPtr] = arr2[j];
                        j++;
                    }
                }
                if (j<arr2.length && k<arr3.length) {
                    if(arr2[j] < arr3[k]) {
                        res[resPtr] = arr2[j];
                        j++;
                    } else {
                        res[resPtr] = arr3[k];
                        k++;
                    }
                }
                if (i<arr1.length && k<arr3.length) {
                    if (arr1[i] < arr3[k]) {
                        res[resPtr] = arr1[i];
                        i++;
                    } else {
                        res[resPtr] = arr3[k];
                        k++;
                    }
                }
            } else {
                if (i<arr1.length) {
                    res[resPtr] = arr1[i];
                    i++;
                }
                if (j<arr2.length) {
                    res[resPtr] = arr2[j];
                    j++;
                }
                if (k<arr3.length) {
                    res[resPtr] = arr3[k];
                    k++;
                }
            }
            resPtr++;
        }
        return res;
    }
    /**
     * Time Complexity: O(arr1.length + arr2.length + arr3.length)
     * Space Complexity: O(arr1.length + arr2.length + arr3.length)
     * @param arr1 int[] sorted arr1
     * @param arr2 int[] sorted arr2
     * @param arr3 int[] sorted arr3
     * @return int[] sorted with above 3
     */
    public static int[] mergeThreeArrays_myInitialApproach(int[] arr1, int[] arr2, int[] arr3) {
        int i=0; int j=0; int k=0;

        int resPtr=0;
        int[] res = new int[arr1.length+arr2.length+arr3.length];
        while (i<arr1.length || j<arr2.length || k<arr3.length) {
            if (i<arr1.length && j<arr2.length && k<arr3.length) {
                // arr1 i has smallest
                if (arr1[i] < arr2[j] && arr1[i] <arr3[k]) {
                    res[resPtr] = arr1[i];
                    i++;
                }
                // arr2 j has smallest
                else if (arr2[j]<arr1[i] && arr2[j]<arr3[k]) {
                    res[resPtr] = arr2[j];
                    j++;
                }
                else {
                    res[resPtr] = arr3[k];
                    k++;
                }
            } else if (i<arr1.length && j<arr2.length || j<arr2.length && k<arr3.length ||  k<arr3.length && i<arr1.length) {
                if (i<arr1.length && j<arr2.length) {
                    if (arr1[i] < arr2[j]) {
                        res[resPtr] = arr1[i];
                        i++;
                    } else {
                        res[resPtr] = arr2[j];
                        j++;
                    }
                }
                if (j<arr2.length && k<arr3.length) {
                    if(arr2[j] < arr3[k]) {
                        res[resPtr] = arr2[j];
                        j++;
                    } else {
                        res[resPtr] = arr3[k];
                        k++;
                    }
                }
                if (i<arr1.length && k<arr3.length) {
                    if (arr1[i] < arr3[k]) {
                        res[resPtr] = arr1[i];
                        i++;
                    } else {
                        res[resPtr] = arr3[k];
                        k++;
                    }
                }
            } else {
                if (i<arr1.length) {
                    res[resPtr] = arr1[i];
                    i++;
                }
                if (j<arr2.length) {
                    res[resPtr] = arr2[j];
                    j++;
                }
                if (k<arr3.length) {
                    res[resPtr] = arr3[k];
                    k++;
                }
            }
            resPtr++;
        }
        return res;
    }
}
