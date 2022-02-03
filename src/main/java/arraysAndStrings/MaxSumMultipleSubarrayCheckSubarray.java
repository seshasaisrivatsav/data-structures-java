package arraysAndStrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * My Explanation: https://leetcode.com/problems/continuous-subarray-sum/discuss/1666972/java-on-with-explanation-and-iteration-run-down
 *
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose
 *  elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 * Example 1:
 *     Input: nums = [23,2,4,6,7], k = 6
 *     Output: true
 *     Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Example 2:
 *     Input: nums = [23,2,6,4,7], k = 6
 *     Output: true
 *     Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 *     42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 *
 * Example 3:
 *     Input: nums = [23,2,6,4,7], k = 13
 *     Output: false
 *
 *     Explanation: https://dev.to/sphoorthi/leetcode-continuous-subarray-sum-459o
 */
public class MaxSumMultipleSubarrayCheckSubarray {
    public static void main(String[] args) {
        System.out.println(3 % 6);
        System.out.println("Expected: false Actual: " + checkSubarraySum(new int[] {0,1,0,3,0,4,0,4,0}, 5));
        System.out.println("Expected: true Actual: " + checkSubarraySum(new int[] {23, 0, 0}, 6));
        System.out.println("Expected: true Actual: " + checkSubarraySum(new int[] {5, 0, 0, 0}, 3));
        System.out.println("Expected: true Actual: " + checkSubarraySum(new int[] {5,23,2,6}, 6));
        System.out.println("Expected: false Actual: " + checkSubarraySum(new int[] {23,2,6,4,7}, 13));
    }

    /*
        For Array arr of length n
        arr = a0, a1, .....ai....aj....an-1
        when we are searching if a sum is a multiple of 'k'

        Sumi = a0+a1+ ... + ai
        Sumj = a0+a1+ ... + aj

        From remainder theorem we know that for two numbers a, b, there exists a constant such that
        a = b*q + r

        Similarly
        Sumi = K*ConstA + modi
        Sumj = K*ConstB + modj

        if modi = modj that means, we've found the range as
        Sumi-Sumj =  K (constA - constB)

        Eg:
        For Array:
        [ 3,  23, 2, 6, 4, 7 ]
        3 + 23 + 2 + 6 = 34
        3 + 23 + 2 = 28

        34 = 6*5 + 4
        28 = 6*4 + 4

        We pre load the hashmap with 0, 1 for the following reason

        Initial:

        arr = [5, 23, 2, 6] k=6
        mod | index
        ---------
         0  | -1

        Iteration 1:
        currMod = 0+5 % 6 = 5 . 5 not in HM, so we add it
        mod | index
        ---------
         0  | -1
         5  |  0

        Iteration 2:
        currMod = 5 + 23 % 6 = 4. 4 not in HM, so we add it
        ---------
         0  | -1
         5  |  0
         4  |  1

        Iteration 3:
        currMod = 4 + 2 % 6 = 0, no since we initially have 0 as -1, we do the following
        iteration - hm.get(currMod)  > 1 => as we need our sub array to be of length > 1
        2 - (-1) = 3 > 1 => return true

     */

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (k==0) { return false; }
        if (nums.length < 2){ return false;}
        int currSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); //
        for (int i=0; i<nums.length; i++) {
            currSum = currSum + nums[i];
            currSum = currSum % k;
            if (hm.containsKey(currSum)) {
                if (i - hm.get(currSum) > 1) {
                    return true;
                }
            } else {
                hm.put(currSum, i);
            }


        }
        return false;
    }
}
