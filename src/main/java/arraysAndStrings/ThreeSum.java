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
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]] actual: " + Arrays.toString(threeSum.threeSum(nums1).toArray()));

        int[] nums = {1, 3, 4, 5, 6, 8};
        System.out.println("Expected: [[1, 2], [0, 4]] actual: " + Arrays.toString(threeSum.twoSum(nums, 7).toArray()));
        System.out.println("Expected: [[5, 0], [2, 3] [1, 4]] actual: " + Arrays.toString(threeSum.twoSum(nums, 9).toArray()));

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
