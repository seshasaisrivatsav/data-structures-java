package sortingAndSearching;

import java.util.*;

/*
	Split array into two equal halves
	TC = Divide + Recursion + Merge
	T(n) = C1 + 2T(n/2) + C.N

		C* N          => Cn
		/ \
	  CN/2  CN/2      => Cn
	............
	 /         \
	C  C  C  C  C     => Cn 	(  n leaves) (levels = 1 + logN)

	T(n) = (1 + logN) * cN = N Log N

	Space Complexity: O(n)

 	body:
		- splits the array into two halves
		- left = o to n/2 -1
		- right = n/2-1 to n
		-
	merge routine:
		- assumes you give it two sorted array
		- The work is done in merge routing
		(two finger algorithm)
		- compare two elements, place smallest one in sorted array
		- complexity of merge: O(n)
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 2, 3, 9, 4, 8, 7, 1, 11, 10 };
		int[] res = mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(res));
	}

	// ------------ vvv Recursive Merge sort  vvv ----------- //
	/**
	 * Step 1: divide the unsorted list into n sublists, each containing one element
	 * Step 2: repeatedly merge sublists to produce new sorted sublists
	 * @param arr int[] arr
	 * @param start int starting index
	 * @param end int ending index
	 * @return int[] merged array
	 */
	public static int[] mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			int[] left = mergeSort(arr, start, mid);
			int[] right = mergeSort(arr, mid + 1, end);
			return mergeRoutine(left, right);
		} else {
			return new int[] { arr[start] };
		}
	}

	public static int[] mergeRoutine(int[] left, int[] right) {
		// i = index of smallest unpicked in left
		// j = index of smallest unpicked in right
		// k = position to be filled in result
		int i = 0, j = 0, k = 0;
		int[] res = new int[left.length + right.length];
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				res[k] = left[i];
				i++;
			} else {
				res[k] = right[j];
				j++;
			}
			k++;
		}

		while (j < right.length) {
			res[k] = right[j];
			j++;
			k++;
		}

		while (i < left.length) {
			res[k] = left[i];
			k++;
			i++;
		}
		return res;
	}
	// ------------ ^^^ Recursive Merge sort  ^^^ ----------- //


	// ------------ vvv Iterative Merge sort  vvv ----------- //

	// TODO: Iterative merge sort
	/**
	 * https://www.baeldung.com/cs/non-recursive-merge-sort
	 * Approach:
	 *
	 * @param arr int[]
	 * @return int[] merged
	 */
	public static int[] mergeSort_iterative(int[] arr) {
		return null;
	}
	// ------------ ^^^ Iterative Merge sort  ^^^ ----------- //
}
