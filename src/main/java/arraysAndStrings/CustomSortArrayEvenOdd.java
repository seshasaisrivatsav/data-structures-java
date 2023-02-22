package arraysAndStrings;

import java.util.Arrays;

/*
 * Given an array of numbers, sort the array into two parts such that no odd numbers appears before even numbers.
 * Even numbers appear in first half, odd appears in second
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class CustomSortArrayEvenOdd {
	public static void main(String[] args) {
		int[] arr = { 13, 10, 21, 20, 22, 23, 25, 24 };
		System.out.println(Arrays.toString(swapArray(arr)));
		int[] arr2 = {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(arr2)));
	}

	/**
	 * 2 pointer approach
	 * with this approach, we have two pointers at start and end
	 * - as long as start < end
	 * 			- if element at start is odd and element at end is even, we swap
	 * 		  - we then check the element parity and increment and decrement pointers
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * @param arr arr
	 * @return int[] array
	 */
	public static int[] sortArrayByParity(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start < end) {
			if (arr[start]%2 !=0 && arr[end]%2 !=1) {
				int temp = arr[start];
				arr[start] =arr[end];
				arr[end] = temp;
			}
			if(arr[start]%2==0) start++;
			if(arr[end]%2==1) end--;
		}
		return arr;
	}
	/**
	 * In place sort
	 * This follows 2 pointer approach where you have start at the first element, end at the last element
	 * as long as start < end
	 * 		- we run a while loop to move start pointer if the number at start is odd
	 * 	  - we run another while loop to move end pointer inward if number at end is even
	 * 	then if start<end, we swap elements at start and end
	 * Time Complexity:
	 * Space Complexity:
	 * @param arr
	 * @return
	 */
	public static int[] swapArray(int[] arr) {
		int end = arr.length-1;
		int start = 0;
		int swaps = 0; // if you wanted to return how many swaps are needed
		while(start < end) {
			while(arr[start]%2 == 0 && start<end) start++;
			while(arr[end]%2 == 1 && start<end) end--;

			if(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
				swaps++;
			}
		}
		System.out.println("number of swaps:" + swaps);
		return arr;
	}

}
