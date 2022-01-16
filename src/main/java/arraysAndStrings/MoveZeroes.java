package arraysAndStrings;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 0, 3, 12 };
        moveZeroes_initialApproach(arr1);;
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = { 0, 1, 0, 3, 12 };
        moveZeroes_efficientApproach(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1};
        moveZeroes_efficientApproach(arr3);
        System.out.println(Arrays.toString(arr3));

    }

    /**
     *
     *
     *  Array Transformation - Meat of tech interviews
     *  The requirement =
     *      1. Move all 0s to the end of array
     *      2. All non zero elements must retain original order
     *   Both 1 and 2 are mutually exclusive. (you can solve individual sub problems and then combine result)
     *
     *  Approach:
     *       2 pointer approach
     *       We can solve it using this
     *          "Bring all non 0 elements to the front of array keeping same original order"
     *       - The fast pointer does the job of processing new elements.
     *       - If the newly found element is not zero, we record it just after the last found non 0 element
     *       - the last found non zero element is denoted by slow pointer
     *       - as we keep finding new non 0 elements, we overwrite them at the slow+1 th index
     *       - after fast reaches end of array we know that all non 0 elements have been moved to beginning of array in original order
     *       - Now we need to fill indexes after slow with 0
     *
     *  TC: O(n)
     *  SC: O(1)
     * @param nums
     */
    public static void moveZeroes_efficientApproach(int[] nums) {
        int slow = 0;
        for (int fast=0; fast<nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow = slow + 1;
            }
        }

        for (int i=slow; i<nums.length; i++) {
            nums[i] = 0;
        }

    }
    public static void moveZeroes_initialApproach(int[] nums) {
        int i=0;int j=0;
        while (i < nums.length) {
            j=i+1;
            if(nums[i]==0 && j < nums.length) {
                while (j<nums.length && nums[j]==0) {
                    j++;
                }
                if (j<nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;
        }
    }
}
