package arraysAndStrings;

import java.util.Arrays;

/*
 * Given an array of numbers, sort the array into two parts such that no odd
 * number appears before even
 */
public class CustomSortArrayEvenOdd {
	public static void main(String[] args) {
		int[] arr = { 13, 10, 21, 20, 22, 23, 25, 24 };
		System.out.println(Arrays.toString(swapArray(arr)));
	}

	public static int[] swapArray(int[] arr) {
		int end = arr.length-1;
		int start = 0;
		int swaps = 0; // if you wanted to return how many swaps are needed
		while(start < end) {
			while(arr[start]%2 == 0 && start<end) start++;
			while(arr[end]%2 == 1 && start<end) end--;

			if(start<end) {
				int temp = arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
				swaps++;
			}
		}
		return arr;
	}

}
