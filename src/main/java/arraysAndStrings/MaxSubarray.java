package arraysAndStrings;

import java.util.Arrays;

/**
 * Leetcode
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *  Algorithm: Kadane's algorithm
 *      - The idea is that at ith element, the subArray either consists of just i or previous subarray + i
 *      - We use two variables currentMax, globalMax
 *      - we initialize both with arr[0]
 *
 * Very well explained https://youtu.be/86CQq3pKSUw
 * https://leetcode.com/problems/maximum-subarray
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class MaxSubarray {
    public static void main(String[] args) {
        System.out.println("Expected: 6 Actual: " + getMaxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})); // {4, -1, 2, 1}
        System.out.println("Expected: 1 Actual: " + getMaxSubArray(new int[] {1})); // whole array
        System.out.println("Expected: 23 Actual: " + getMaxSubArray(new int[] {5, 4, -1, 7, 8})); // whole array

        System.out.println("Expected: 6 Actual: " + getMaxSubarrayRecursion(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})); // {4, -1, 2, 1}
        System.out.println("Expected: 1 Actual: " + getMaxSubarrayRecursion(new int[] {1})); // whole array
        System.out.println("Expected: 23 Actual: " + getMaxSubarrayRecursion(new int[] {5, 4, -1, 7, 8})); // whole array
    }

    public static int getMaxSubArray(int[] arr) {
        if (arr.length == 1) { return arr[0]; }

        int currMax = arr[0];
        int globalMax = arr[0];

        int[] indices = new int[2];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] + currMax > arr[i]) {
                currMax = currMax + arr[i];
            } else {
                indices[0] = i;
                currMax = arr[i];
            }
            if (currMax > globalMax) {
                indices[1] = i;
                globalMax = currMax;
            }
        }

        System.out.println("Indices: " + Arrays.toString(indices));
        System.out.println("Ranges: " + arr[indices[0]] + " " + arr[indices[1]]);
        return globalMax;
    }

    public static int getMaxSubarrayRecursion(int[] arr) {
        return maxSubarrayRecurseHelper(arr, 0, arr.length-1);
    }

    public static int maxSubarrayRecurseHelper(int[] arr, int start, int end) {
        if (start > end) { return Integer.MIN_VALUE; }

        int mid = (start + end)/2;
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        // iterate from middle to beginning (mid not included)
        for (int i=mid-1; i >=start; i--) {
            curr = curr + arr[i];
            bestLeftSum = Math.max(curr, bestLeftSum);
        }


        // iterate from middle to end (mid not included)
        curr = 0;
        for (int i=mid+1; i<=end; i++) {
            curr = curr + arr[i];
            bestRightSum = Math.max(curr, bestRightSum);
        }

        // the bestCombined sum uses middle element and best possible sum from each half
        int bestCombined = arr[mid] + bestLeftSum + bestRightSum;

        // finding best subarray from both halves
        int leftHalf = maxSubarrayRecurseHelper(arr, start, mid-1);
        int rightHalf = maxSubarrayRecurseHelper(arr, mid+1, end);

        // largest of 3 is the answer
        return Math.max(bestCombined, Math.max(leftHalf, rightHalf));
    }
}
