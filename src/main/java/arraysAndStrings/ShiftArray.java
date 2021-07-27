package arraysAndStrings;

import java.util.Arrays;

public class ShiftArray {

	public static void main(String[] args) {
		int[] A= {7, 8, 9, 6, 5, 4, 5, 6,7, 11, 0, 0 , 0 , 0};
		
		shiftArray(A, 3, 4);
	}

	public static void shiftArray(int[] nums1, int shiftIndex, int shiftTimes) {

		for (int i = nums1.length; i > 0; i--) {
			if (i >= shiftIndex && (i + shiftTimes) < nums1.length) {
				nums1[i + shiftTimes] = nums1[i];
			}
		}
		
		System.out.println(Arrays.toString(nums1));

	}

}
