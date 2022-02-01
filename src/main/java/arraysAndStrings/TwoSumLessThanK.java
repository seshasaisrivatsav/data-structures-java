package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array nums of integers and integer k, return the maximum sum such that there
 * exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 *
 *  Example 1:
 *           Input: nums = [34,23,1,24,75,33,54,8], k = 60
 *          Output: 58
 *          Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 *  Example 2:
 *       Input: nums = [10,20,30], k = 15
 *       Output: -1
 *       Explanation: In this case it is not possible to get a pair sum less that 15.
 *  Companies: Amazon, Facebook
 */
public class TwoSumLessThanK {

    public static void main(String[] args) {
        int[] nums1 = { 10, 20, 30 };
        System.out.println("Expected: -1 Actual: " + twoSumLessThanK(nums1, 15));

        int[] nums2 = { 34,23,1,24,75,33,54,8 };
        System.out.println("Expected: -1 Actual: " + twoSumLessThanK(nums2, 60));
    }

    public static int twoSumLessThanK(int[] nums, int k) {
        int res = -1;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (start < end) {
            int currSum = nums[start] + nums[end];
            if (currSum < k) {
                res = Math.max(res, currSum);
                start ++;
            } else {
                end --;
            }
        }
        return res;
    }
}