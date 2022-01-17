package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static arraysAndStrings.MissingRanges.formatRange;

/**
 * https://leetcode.com/problems/summary-ranges/
 *
 * You are given a sorted unique integer array nums.
 *
 *  Approach: Have a pointer and keep going until you find a disconnect.
 *            In each iteration, remember where the pointer is
 *            if the pointers differ, then create range, or else, add one
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *      "a->b" if a != b
 *      "a" if a == b
 *
 *  Example 1:
 *       Input: nums = [0,1,2,4,5,7]
 *      Output: ["0->2","4->5","7"]
 *      Explanation: The ranges are:
 *          [0,2] --> "0->2"
 *          [4,5] --> "4->5"
 *          [7,7] --> "7"
 * Example 2:
 *      Input: nums = [0,2,3,4,6,8,9]
 *      Output: ["0","2->4","6","8->9"]
 *      Explanation: The ranges are:
 *          [0,0] --> "0"
 *          [2,4] --> "2->4"
 *          [6,6] --> "6"
 *          [8,9] --> "8->9"
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).toArray())); // [0->2, 4->5, 7]
        System.out.println(Arrays.toString(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}).toArray())); // [0, 2->4, 6, 8->9]
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<nums.length) {
            int ptr = i;
            while (i+1< nums.length && nums[i]+1==nums[i+1]) {
                i++;
            }
            if (i==ptr) {
                res.add(String.valueOf(nums[i]));
            } else if (nums[i] > nums[ptr]) {
                res.add(nums[ptr] + "->" +nums[i]);
            }
            i++;
        }
        return res;
    }
}
