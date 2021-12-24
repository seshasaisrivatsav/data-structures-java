package sortingAndSearching;

import java.util.Arrays;

/*
 * Merge two arrays in the same array as the first one 
 */
public class MergeTwoSortedArraysInPlace {

	public static void main(String[] args) {
		int[] nums1 = { 1, 4, 5, 6, 0, 0, 0 };
		int[] nums2 = { 2, 3, 7 };
		merge(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		// Move pointers i and j to last element of each array
		// K will be the last most 
		// when you start comparing from ends, whatever element is greater you'll put it in K
		// Merge two sorted arrays
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (j >= 0) {
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
