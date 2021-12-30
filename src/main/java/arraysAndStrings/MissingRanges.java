package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
- You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
- A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly.
That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:
    - "a->b" if a != b
    - "a" if a == b

Example 1:
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"

Example 2:
Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.

 */
public class MissingRanges {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99).toArray()));
        System.out.println(Arrays.toString(getMissingRanges(new int[]{-1}, -1, -1).toArray()));
        System.out.println(Arrays.toString(getMissingRanges(new int[]{}, 1, 1).toArray()));
        System.out.println(Arrays.toString(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99).toArray()));
        System.out.println(Arrays.toString(findMissingRanges(new int[]{-1}, -1, -1).toArray()));
        System.out.println(Arrays.toString(findMissingRanges(new int[]{}, 1, 1).toArray()));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        // Base case: if length is 0 of if array is empty
        if (nums.length == 0) {
            res.add(formatRange(lower, upper));
            return res;
        }

        // Step 1: Find the range between lower and first element
        if (lower < nums[0]) {
            res.add(formatRange(lower, nums[0]-1));
        }
        // Step 2: construct ranges between adjacent elements
        for (int i=0; i<nums.length-1; i++) {
            if ((nums[i]!=nums[i+1]) && (nums[i]+1 < nums[i+1])) {
                res.add(formatRange(nums[i]+1, nums[i+1]-1));
            }
        }
        // Step 3: find range between last and upper
        if (nums[nums.length-1] < upper) {
            res.add(formatRange(nums[nums.length-1]+1, upper));
        }
        return res;
    }

    /**
     * Algorithm
     *  number + 1  <= next number - 1
     *
     *  Edge cases
     *      Lower bound (first num): (start-1) + 1 <= first num -1
     *      Upper Bound (last num): (end) + 1 <= last num -1
     *
     *  When
     *      nums[i]-nums[i-1] == 1, no missing elements between i and i-1
     *      nums[i]-nums[i-1] >1, the missing range is [nums[i-1]+1, nums[i]-1]
     *
     *  Edge case
     *      1. if we don't start with lower as the first element of the array, we need to missing range [start, nums[0]-1] must be added
     *      2. if we don't end with upper as last element of the array, we need to include [nums[n-1]+1, end] where n = length of the array
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static List<String> getMissingRanges(int[] nums, int start, int end) {
        List<String> res = new ArrayList<>();
        int prev = start-1;
        for (int i=0; i<= nums.length; i++) {
            int curr = (i<nums.length) ? nums[i] : end +1;
            if (prev+1 <= curr-1) {
                res.add(formatRange(prev+1, curr-1));
            }
            prev = curr;
        }
        return res;
    }

    public static String formatRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }
}
