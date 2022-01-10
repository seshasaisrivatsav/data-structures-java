package arraysAndStrings;

import java.util.Arrays;

public class RotateArray {
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,7,8};
		int rTimes=5;

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		rotateArray_clockwise_reversal(arr, 3);
		System.out.println(Arrays.toString(arr));

		int[] arr2 = {1};
		rotateArray_clockwise_reversal(arr2, 0);

		int[] arr4 = {1, 2};
		rotateArray_clockwise_reversal(arr4, 2);
	}


	/**
	 * Approach 1: Rotate array of length n, r times
	 * 		     Array = (n-r) array + (r) array
	 * 		     Reverse (n-r) array, Reverse (r) array
	 * 		     Reverse the above
	 *
	 * 		     Eg: 1, 2, 3, 4, 5, 6, 7  n=7, r=3
	 * 		     Reverse (7-3 = 4) array, reverse 3 array
	 * 		     (1, 2, 3, 4) , (5, 6, 7)
	 * 		     (4, 3, 2, 1), (7, 6, 5)
	 * 		     Reverse the above
	 * 		     5, 6, 7, 1, 2, 3, 4, 5
	 * Time Complexity: O(N)
	 * Space Complexity
	 * @param arr int[]
	 * @param times int
	 */
	public static void rotateArray_clockwise_reversal(int[] arr, int times) {
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

}
