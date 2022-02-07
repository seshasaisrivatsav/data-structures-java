package arraysAndStrings;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) if you take output into account and O(1)O(1) otherwise.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 *
 */
public class SortedSquares {
    public static void main(String[] args) {
        System.out.println("Expected: [0,1,9,16,100] Actual:" + Arrays.toString(getSortedSquares(new int[] {-4,-1,0,3,10})));
        System.out.println("Expected: [4,9,9,49,121] Actual:" + Arrays.toString(getSortedSquares(new int[] {-7,-3,2,3,11})));
        System.out.println("Expected: [4,9,9,49,121] Actual:" + Arrays.toString(getSortedSquares(new int[] {-5, -3, -2, -1})));
        System.out.println("Expected: [0,1,9,16,100] Actual:" + Arrays.toString(getSortedSq_2ptr(new int[] {-4,-1,0,3,10})));
        System.out.println("Expected: [4,9,9,49,121] Actual:" + Arrays.toString(getSortedSq_2ptr(new int[] {-7,-3,2,3,11})));
        System.out.println("Expected: [4,9,9,49,121] Actual:" + Arrays.toString(getSortedSq_2ptr(new int[] {-5, -3, -2, -1})));
    }

    public static int[] getSortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length-1;

        // -3, -1 , 0 , 1, 2
        //  |              |
        for (int i=nums.length-1; i>=0; i--) {
            if (Math.abs(nums[end]) > Math.abs(nums[start])) {
                res[i] = nums[end];
                end--;
            } else {
                res[i] = nums[start];
                start++;
            }
            res[i] = res[i] * res[i];
        }

        return res;

    }

    public static int[] getSortedSq_2ptr(int[] nums) {
        int[] res = new int[nums.length];
        int k = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] < 0) {
                i++;
            } else {
                break;
            }
        }

        int j = i;
        i = i-1;

        if (j==0) {
            for (int num: nums) {
                res[k] = num*num;
                k++;
            }
            return res;
        }

        // -5, -3, -2, -1, 0 , 1 , 2, 3, 4
        // 5 < 4
        // 25
        if (j > nums.length) {
            for (int num: nums) {
                res[nums.length-1-k] = num*num;
                k--;
            }
            return res;
        }



        while (i>=0 && j<nums.length) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a < b) {
                res[k] = a;
                i--;
            } else {
                res[k] = b;
                j++;
            }
            k++;
        }

        while (i >= 0) {
            res[k] = nums[i] * nums[i];
            i--;
            k++;
        }

        while (j<nums.length) {
            res[k] = nums[j] * nums[j];
            j++;
            k++;
        }
        return res;
    }
}
