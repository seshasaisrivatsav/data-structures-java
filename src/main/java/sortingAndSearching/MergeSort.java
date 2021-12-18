/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAndSearching;

import java.util.*;

/**
 *
 * @author seshasai
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 2, 3, 9, 4, 8, 7, 1, 11, 10 };
		int[] res = mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(res));
	}

	// Dividing the array
	public static int[] mergeSort(int[] a, int s, int e) {

		if (s < e) {
			int mid = (s + e) / 2;
			int[] l = mergeSort(a, s, mid);
			int[] r = mergeSort(a, mid + 1, e);

			return merge(l, r);

		} else {
			return new int[] { a[s] };
		}

	}

	public static int[] merge(int[] l, int[] r) {

		int i = 0, j = 0, k = 0;
		int res[] = new int[l.length + r.length];

		while (i < l.length && j < r.length) {
			if (l[i] < r[j]) {
				res[k] = l[i];
				i++;
				k++;
			} else {
				res[k] = r[j];
				j++;
				k++;
			}
		}

		while (j < r.length) {
			res[k] = r[j];
			j++;
			k++;
		}

		while (i < l.length) {
			res[k] = l[i];
			k++;
			i++;
		}

		return res;

	}

	// Merge the array
}
