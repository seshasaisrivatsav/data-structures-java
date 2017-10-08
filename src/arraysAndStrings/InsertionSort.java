package arraysAndStrings;

import java.util.Arrays;

public class InsertionSort {

	
	public static void main(String[] args) {
		int[] a = {12,7,8,2,3,0,112,1,5};
		System.out.print(Arrays.toString(insertionSort(a)));
	}
	
	
	public static int[] insertionSort(int[] a) {
		int key,j;
		for(int i=1; i<a.length;i++) {
			key = a[i];
			j=i-1;
			
			while(j>=0 && a[j]>key) {
				a[j+1] = a[j];
				j=j-1;
			}
			a[j+1]=key;
			
		}
		return a;
		
	}
}
