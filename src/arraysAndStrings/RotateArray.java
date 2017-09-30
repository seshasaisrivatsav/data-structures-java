package arraysAndStrings;

public class RotateArray {
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8};
		int rTimes=5;
		
		// Rotate as many times as needed
		for(int i=0; i<rTimes;i++) {
			rotateArrayOnce(A);
		}
		
	 
		// Print array
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+ " ");
		}
	}
	
	/*
	 * Left Rotate an array once
	 */
	public static void rotateArrayOnce(int[] A) {
		int i, temp;
		temp=A[0];
		for(i=0; i<A.length-1;i++) {
			A[i]=A[i+1];
		}
		A[i]=temp;
		 
		
		
		
	}

}
