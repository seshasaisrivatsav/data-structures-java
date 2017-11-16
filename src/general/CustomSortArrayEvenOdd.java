package general;

public class CustomSortArrayEvenOdd {

	/*
	 * Given an array of numbers, sort the array into two parts such that no odd
	 * number appears before even
	 */
	public static void main(String[] args) {
		int[] A = { 13, 10, 21, 20 };
		int p = A.length-1;
		int n=0;
		int swaps =0;
		while(p>n) {
			while(A[n]%2 == 0 && p>n) n++;
			while(A[p]%2 == 1 && p>n) p--;
			
			if(n<p) {
				int temp = A[n];
				A[n]=A[p];
				A[p]=temp;
				n++;p--;
				swaps++;
			}
		}
		
		System.out.println(swaps);
	}

}
