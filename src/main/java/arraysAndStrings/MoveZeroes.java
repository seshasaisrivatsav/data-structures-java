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
        int[] arr1 = { 0, 1, 0, 3, 12};
        moveZeroes_initialApproach(arr1);
        System.out.println(Arrays.toString(arr1));
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
