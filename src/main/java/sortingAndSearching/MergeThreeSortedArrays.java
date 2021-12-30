package sortingAndSearching;

import java.util.Arrays;

public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 9, 13, 16 };
        int[] arr2 = { 2, 5, 10, 15, 19 };
        int[] arr3 = { 3, 6, 11, 14, 20 };
        System.out.println(Arrays.toString(mergeThreeArrays_myInitialApproach(arr1, arr2, arr3)));
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
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
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
