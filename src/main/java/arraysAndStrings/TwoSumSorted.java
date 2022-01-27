package arraysAndStrings;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 *
 *
 * Example 1:
 *      Input: numbers = [2,7,11,15], target = 9
 *      Output: [1,2]
 *      Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Example 2:
 *      Input: numbers = [2,3,4], target = 6
 *      Output: [1,3]
 *      Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 *
 * Example 3:
 *      Input: numbers = [-1,0], target = -1
 *      Output: [1,2]
 *      Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 * Companies:
 *  Amazon, Google, Microsoft, Adobe, Apple
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSumSorted {
    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * Approach:
     *      Since the array is sorted, we can use two indices initially pointing to first and last element
     *      Compare both elements, if the sum=target, we've found a solution
     *                             if the sum < target, increment smaller index by 1
     *                             if the sum > target, decrement larger index by 1
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums int[] given array
     * @param target int target sum
     * @return int[] indices of matching target (leetcode wants index+1 to be returned)
     */
    public static int[] twoSum_twoPointer(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
            int currSum = nums[start] + nums[end];
            if (currSum == target) {
                return new int[] {start+1, end+1};
            }
            if (currSum < target) {
                start ++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

}
