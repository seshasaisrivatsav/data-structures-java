package sorting;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		int[] A1 = {1,3,5,7,10};
		int[] A2 = {2, 4, 9, 11, 12};
		mergeEm(A1, A2);
	}

	public static void mergeEm(int[] A1, int[] A2) {
		int res[] = new int[A1.length + A2.length];
		// i = Iterator for A1
		// j = Iterator for A2
		// k = For res
		int i=0, j=0, k=0;
		
		// Traverse both arrays 
		while(i<A1.length && j <A2.length) {
			if(A1[i]<A2[j]) {
				res[k]=A1[i];
				k++;i++;
			}else {
				res[k]=A2[j];
				k++;j++;
			}
		}
		
		
		// Store remaining elements of first array A1 
		while(i<A1.length) {
			res[k]= A1[i];
			k++;i++;
		}
		
		// Store remaining elements of first array A2
		while(j<A2.length) {
			res[k]=A2[j];
			k++;j++;
		}
		
		for ( j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
