package sorting;

import java.util.Arrays;

public class InsertionSort {

	
	public static void main(String[] args) {
		int[] a = {-9, -8,9,8,7,6,5,4,3,2,1,-20};
		System.out.print(Arrays.toString(insertionSort(a)));
	}
	
	
	// It is like shuffle, for each iteration, the array till that iteration is sorted
	public static int[] insertionSort(int[] a) {
		int key,j;
		// we start from i=1 as till i=0 is already sorted
		for(int i=1; i<a.length;i++) {
			// store each a[i] in key 
			key = a[i];
			// j will be one less than i
			j=i-1;
			
			// as long as j>=0 and a[j] >key, we keep key in memory
			// and move j to next position
			// After we move, we decrement j to shuffle
			while(j>=0 && a[j]>key) {
				a[j+1] = a[j];
				j=j-1;
			}
			// Since j is decremented below, we increment and store key
			a[j+1]=key;
			
		}
		return a;
		
	}
}
