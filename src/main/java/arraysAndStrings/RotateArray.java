package arraysAndStrings;

import java.util.Arrays;

/**
 * Right Rotate = Clockwise rotation
 * <a href="https://leetcode.com/problems/rotate-array/description/">...</a>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *	Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		rotateArray_clockwise(arr, 3);
		System.out.println(Arrays.toString(arr));

		int[] arr1 = {1,2,3,4,5,6,7,8};
		rotateArray_clockwise(arr1, 5);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = {1};
		rotateArray_clockwise(arr2, 0);
		System.out.println(Arrays.toString(arr2));

		int[] arr4 = {1, 2};
		rotateArray_clockwise(arr4, 2);
		System.out.println(Arrays.toString(arr4));

		int[] arr5 = {1,2, 3, 4, 5};
		rotateArray_clockwise(arr5, 1);
		System.out.println(Arrays.toString(arr5));

		int[] arr6 = {1,2, 3, 4, 5};
		rotateArray_antiClockwise(arr6, 2);
		System.out.println(Arrays.toString(arr6));
	}


	/**
	 * Approach: Rotate array of length n, r times
	 * 		     Array = (n-r) array + (r) array
	 * 		     Reverse (n-r) array, Reverse (r) array
	 * 		     Reverse the above
	 * 		     Eg: 1, 2, 3, 4, 5, 6, 7  n=7, r=3
	 * 		     To rotate this thrice 1, 2, 3, 4, 5, 6, 7
	 * 		     1st rotation: 7, 1, 2, 3, 4, 5, 6
	 * 		     2nd rotation: 6, 7, 1, 2, 3, 4, 5
	 * 		     3rd rotation: 5, 6, 7, 1, 2, 3, 4
	 * 		     Reverse (7-3 = 4) array, reverse 3 array
	 * 		     (1, 2, 3, 4) , (5, 6, 7)
	 * 		     (4, 3, 2, 1), (7, 6, 5)
	 * 		     Reverse the above
	 * 		     5, 6, 7, 1, 2, 3, 4, 5
	 * Time Complexity: O(N)
	 * Space Complexity: O(1) in place
	 * @param arr int[]
	 * @param times int
	 */
	public static void rotateArray_clockwise(int[] arr, int times) {
		if (times >= arr.length) {
			times = times % arr.length; // coz rotating array of length 5, 5 times, 10 times is same
		}
		if (arr.length==0 || arr.length==1 || times == 0) {return;}
		reverseArray(arr, 0, arr.length-times-1);
		reverseArray(arr, arr.length-times, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}

	public static void reverseArray(int[] arr, int start, int end) {
		while(start <= (start+end)/2) {
			int curr = arr[end];
			arr[end] = arr[start];
			arr[start] = curr;
			start++;
			end--;
		}
	}

	/**
	 * Approach: Rotate array of length n, r times
	 * 		     Step 1: Array = (n) array + (n-r) array
	 * 		     Step 2: Reverse (n) array, Reverse (n-r) array
	 * 		     Step 3: Reverse the above
	 * 		     Rundown:
	 * 		     Eg: 1, 2, 3, 4, 5, 6, 7  n=7, r=3
	 * 		     To rotate this thrice 1, 2, 3, 4, 5, 6, 7
	 * 		     1st rotation: 2, 3, 4, 5, 6, 7, 1
	 * 		     2nd rotation: 3, 4, 5, 6, 7, 1, 2
	 * 		     3rd rotation: 4, 5, 6, 7, 1, 2, 3
	 * 		     Reverse (3) array, reverse (7-3=4) array
	 * 		     (1, 2, 3) , (4, 5, 6, 7)
	 * 		     (3, 2, 1), (7, 6, 5, 4)
	 * 		     Reverse the above
	 * 		     4, 5, 6, 7, 1, 2, 3
	 * Time Complexity: O(N)
	 * Space Complexity: O(1) in place
	 * @param arr int[]
	 * @param times int
	 */
	public static void rotateArray_antiClockwise(int[] arr, int times) {
		times = times % arr.length;
		if (times == 0 || arr.length == 1) {
			return;
		}
		reverseArray(arr, 0, times-1);
		reverseArray(arr, times, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}
}
