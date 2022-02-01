package arraysAndStrings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *  Example 1:
 *      Input: arr = [17,18,5,4,6,1]
 *      Output: [18,6,6,6,1,-1]
 *      Explanation:
 *      - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 *      - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 *      - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 *      - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 *      - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 *      - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Companies: Facebook
 */
public class ReplaceElementsWithGreatestOnRight {
    public static void main(String[] args) {
        int[] arr1 = {17, 18,5,4,6,1};
        System.out.println("Expected: [18, 6, 6, 6, 1, -1] Actual: " + Arrays.toString(replaceElementsOnRight(arr1)));
    }

    /**
     * Approach: approach from right and insert bigger one
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums int[] nums
     * @return int[] where  each number has greatest element to right of that index
     */
    public static int[] replaceElementsOnRight(int[] nums) {
        if (nums.length==1) { return new int[] {-1};}
        int max = -1;
        for (int i=nums.length-1; i>=0; i--) {
            int curr = nums[i];
            nums[i] = max;
            max = Math.max(nums[i], curr);
        }
        return nums;
    }
}
