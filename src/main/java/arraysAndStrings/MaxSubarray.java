package arraysAndStrings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Companies: Amazon, LinkedIn, Apple, Microsoft, Google, Adobe, Cisco, Facebook, Salesforce
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

    /**
     * Algorithm: Kadane's algorithm
     *       - The idea is that at ith element, the subArray either consists of just i or previous subarray + i
     *       - We use two variables currentMax, globalMax
     *       - we initialize both with arr[0]
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     *  Very well explained https://youtu.be/86CQq3pKSUw
     * @param arr int[] arr
     * @return int representing max sum
     */
    public static int getMaxSubArray(int[] arr) {
        if (arr.length == 1) { return arr[0]; }

        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for (int i=1; i<arr.length; i++) {
            // At each step, we either choose curr if it gives us more than max curr
            // V.V.I.P Otherwise, we start from that position by setting maxCurrent to arr[i]
            if (arr[i] + maxCurrent > arr[i]) {
                maxCurrent = arr[i] + maxCurrent;
            } else {
                maxCurrent = arr[i];
            }
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }

            // Above two can be simplified to
            // maxCurrent = Math.max(arr[i], arr[i]+maxCurrent);
            // maxGlobal = Math.max(maxCurrent, maxGlobal);
        }
        return maxGlobal;
    }

    /**
     * Return the start and end indices of the max sub array
     * @param arr int[]
     * @return int max sum
     */
    public static int getMaxSubArray_indicesAndRanges(int[] arr) {
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
