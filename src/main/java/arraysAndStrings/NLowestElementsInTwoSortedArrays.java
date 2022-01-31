package arraysAndStrings;

import java.util.Arrays;

/**
 * Given two sorted arrays and a number, return the first N elements if both the arrays were merged
 */
public class NLowestElementsInTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9};
        int[] arr2 = { 2, 4, 6, 8, 10};
        System.out.println("Expected: [1, 2, 3, 4] Actual: " + Arrays.toString(getNLowestElements(arr1, arr2, 4)));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7] Actual: " + Arrays.toString(getNLowestElements(arr1, arr2, 7)));


        int[] arr3 = { 1, 2, 3, 4, 5 };
        int[] arr4 = { 6, 7, 8, 9, 10};
        System.out.println("Expected: [1, 2, 3, 4] Actual: " + Arrays.toString(getNLowestElements(arr3, arr4, 4)));

        int[] arr5 = {1};
        int[] arr6 = {1, 2, 3, 4};
        System.out.println("Expected: [1, 1, 2] Actual: " + Arrays.toString(getNLowestElements(arr5, arr6, 3)));

        int[] arr7 = {};
        int[] arr8 = {1, 2, 3};
        System.out.println("Expected: [1, 2] Actual: " + Arrays.toString(getNLowestElements(arr7, arr8, 2)));

    }

    /**
     * Approach: We use a result array with size on N
     *          and use 3 pointers i, j, k that move along nums1, nums2 and res array
     *          by comparing the values of nums1 and nums2 we move smallest into res and move pointers accordingly
     *
     *  Time Complexity: O(N) => Where N = size
     *  Space Complexity: O(1)
     * @param nums1 int[] sorted array 1
     * @param nums2 int[] sorted array 2
     * @param n number of lowest elements we're looking for
     * @return int[] sorted first N
     */
    public static int[] getNLowestElements(int[] nums1, int[] nums2, int n) {
        int[] res = new int[n];
        int i=0;
        int j=0;
        int k=0;
        while (k<res.length && i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (k<res.length && i<nums1.length) {
            res[k] = nums1[i];
            i++;
            k++;
        }
        while (k<res.length && j<nums2.length) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        return res;
    }
}
