package sortingAndSearching;

public class QuickSort {
	public static void main(String[] args) {
		int[] aa = { 2, 3, 9, 4, 8, 7, 1, 11, 10 };
		  
		Integer i=1, j=1;
		i++; 
		System.out.println(i==j);
		 //quickSort(a, 0, a.length - 1);
		//System.out.println(Arrays.toString(quickSort(a, 0, a.length - 1)));
	}
	
	// quickSort takes Integer array, a low and a high
	public static void quickSort(int[] a, int l, int h) {
		if(l<h) {
			// p = partitionIndex
			int p = partition(a, l,h);
			quickSort(a, l, p-1);
			quickSort(a, p+1, h);
		}
		
	}

	private static int partition(int[] a, int l, int h) {
		// TODO Auto-generated method stub
		return 0;
	}
}
