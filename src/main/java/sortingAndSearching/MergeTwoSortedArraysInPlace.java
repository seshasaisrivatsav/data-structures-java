package sortingAndSearching;

import java.util.Arrays;

/*
 Merge two arrays in the same array as the first one
 https://leetcode.com/problems/merge-sorted-array/

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
Example 1:
	Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	Output: [1,2,2,3,5,6]
	Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
	The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
	Input: nums1 = [1], m = 1, nums2 = [], n = 0
	Output: [1]
	Explanation: The arrays we are merging are [1] and [].
	The result of the merge is [1].

Example 3:
	Input: nums1 = [0], m = 0, nums2 = [1], n = 1
	Output: [1]
	Explanation: The arrays we are merging are [] and [1].
	The result of the merge is [1].
	Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

Various Approaches
	Approach 1: Merge sorted array with extra space like merge sort - TC : O(m+n) Spa

Companies: Facebook, Amazon, Microsoft
 */
public class MergeTwoSortedArraysInPlace {

	public static void main(String[] args) {
		int[] nums1 = { 1, 4, 5, 6, 0, 0, 0 };
		int[] nums2 = { 2, 3, 7 };
		merge(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}


	/**
	 * Approach : Reverse approach.
	 * 			  Come from reverse (3 pointer - )
	 * 			  1. Have a pointer at end of large array
	 * 			  2, 3 - at last element of each array
	 *
	 * 			  put the largest in k, decrement pointers accordingly
	 * @param nums1 array 1
	 * @param m  array 1's length
	 * @param nums2  array 2
	 * @param n  array 2's length
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		// Move pointers i and j to last element of each array
		// K will be the last most 
		// when you start comparing from ends, whatever element is greater you'll put it in K
		// Merge two sorted arrays
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		// while second array hasn't reached the beginning
		while (j >= 0) {
			// if first array hasn't reached the beginning and first array has bigger number
			if (i>=0 && (nums1[i] > nums2[j])) {
				nums1[k] = nums1[i];
				i--;
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
	}
}
