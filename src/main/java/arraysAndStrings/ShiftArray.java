package arraysAndStrings;

import java.util.Arrays;

public class ShiftArray {
	public static void main(String[] args) {
		int[] arr = {7, 8, 9, 6, 5, 4, 5, 6,7, 11, 0, 0 , 0 , 0};
		shiftArray(arr, 3, 4);
		System.out.println(Arrays.toString(arr));
	}

	public static void shiftArray(int[] nums, int shiftIndex, int shiftTimes) {
		for (int i = nums.length; i > 0; i--) {
			if (i >= shiftIndex && (i + shiftTimes) < nums.length) {
				nums[i + shiftTimes] = nums[i];
			}
		}
	}

}
