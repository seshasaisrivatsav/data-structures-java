package arraysAndStrings;

import java.util.Arrays;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber_xor(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber_sumToNFormula(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    /**
     * a ^ b ^ b = a;
     * @param nums
     * @return
     */
    public static int missingNumber_xor(int[] nums) {
        int xorRes = 0;
        int i = 0;
        while (i < nums.length) {
            xorRes = xorRes ^ i ^ nums[i];
            i++;
        }
        return i ^ xorRes;
    }
    /**
     * n (n+1)/2 = E n
     *
     *
     * @param nums
     * @return
     */
    public static int missingNumber_sumToNFormula(int[] nums) {
        int sumToN = (nums.length+1)*(nums.length)/2;
        int actualSum = 0;
        for (int i=0; i<nums.length; i++) {
            actualSum+=nums[i];
        }
        return sumToN-actualSum;
    }
    /**
     * TC: O(n log n)
     * SC: O(1)
     * @param nums
     * @return
     */
    public static int missingNumber_usingSorting(int[] nums) {
        Arrays.sort(nums);
        if (nums[0]!=0) { return 0; }
        // until last element
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]+1 != nums[i+1]) {
                return nums[i]+1;
            }
        }
        // for last element
        if (nums[nums.length-1]!=nums.length-1) {
            return nums.length-1;
        }
        return nums.length;
    }
}
