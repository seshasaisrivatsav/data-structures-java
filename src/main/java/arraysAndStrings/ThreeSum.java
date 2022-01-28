package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 3 Sum
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * Companies:
 *  Amazon, Facebook, Apple, Microsoft, Google, Adobe, Oracle
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        int[] nums2 = { -1,0,1,2,-1,-4 };
        System.out.println("Expected: [[-1, -1, 2],[-1, 0, 1]] actual: " + Arrays.toString(threeSum.threeSum_twoPointerApproach(nums2).toArray()));

        int[] nums3 = { -2, 0, 1, 1, 2};
        System.out.println("Expected: [[-2, 0, 2],[-2, 1, 1]] actual: " + Arrays.toString(threeSum.threeSum_twoPointerApproach(nums3).toArray()));
    }

    /**
     * Approach:
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_noSortApproach(int[] nums) {
        return null;
    }

    /**
     *
     *  Time Complexity: O(n2) = O(n2 + n log n)
     *  Space Complexity: O(log n) to O(n) depending on the sorting algo used
     *
     * Approach:
     *      - Sort the array => O(n log n)
     *      - Iterate through the array =>
     *          - if the current value > zero, break from loop (as remaining values can't sum to 0)
     *          - if current value is same as one before it, skip => we do it to avoid duplicates in result
     *          - if not, call twoSum for current position 'currIndex'
     *
     *       - Two sum approach
     *           - set the 'start' pointer to 'currIndex+1' and 'end' pointer to the last index
     *           - while start < end
     *              - if sum(nums[currIndex] + nums[start] + nums[end]) < 0  ==> then increment 'start'
     *              - if that sum > 0   ===> decrement 'end'
     *              - otherwise, we found a triplet
     *                  - add it to result
     *                  - decrement 'end' and increment 'start'
     *                  - increment 'start' while next value is same as before to avoid duplicates
     *
     * @param nums int[] given
     * @return List<List<Integer>> list of integers that add up to 0
     */
    public List<List<Integer>> threeSum_twoPointerApproach(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // Case when all elements are > 0 after sorting
        if (nums[0] > 0) {  return res; }
        for (int i=0; i<nums.length; i++) {
            // if previous number is not same as the current, only then check 2sum to avoid duplicates
            if (i == 0 || nums[i-1] != nums[i]) {
                threeSum_helper(nums, i, res);
            }
        }
        return res;
    }

    // Time Complexity: O(N)
    public void threeSum_helper(int[] nums, int currIndex, List<List<Integer>> res) {
        int start = currIndex + 1;  // start 1 position after
        int end = nums.length - 1; // end at the end of the array
        while (start < end) {
            int currSum = nums[currIndex] + nums[start] + nums[end];
            if (currSum < 0) {
                start ++;
            } else if (currSum > 0) {
                end --;
            } else {
                // we found a 0 when the numbers at three positions are added
                res.add(Arrays.asList(nums[currIndex], nums[start], nums[end]));
                // for the next iteration
                start ++;
                end --;
                while (start < end && nums[start] == nums[start-1]) {
                    start ++;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num: nums) {
            List<List<Integer>> indexLocal = twoSum(nums, -1*num);
            if (indexLocal.size() > 0) {
                // add num to each item in list
                List<Integer> localRes  = new ArrayList<>();
                for (int i=0; i<indexLocal.size(); i++) {
//
//                    curr.add(num);
//                    res.add(curr);
                }
            }
        }
        return res;
    }

    /**
     * Return list of set of 2 indices that return a sum
     * @param nums int[] nums
     * @param k int sum
     * @return List<Integer> representing indices of numbers that add up to l
     */
    public List<List<Integer>> twoSum(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // difference, index
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                List<Integer> pointers = new ArrayList<>();
                pointers.add(i);
                pointers.add(hm.get(nums[i]));
                res.add(pointers);
            } else {
                hm.put(k-nums[i], i);
            }
        }
        return res;
    }
}
