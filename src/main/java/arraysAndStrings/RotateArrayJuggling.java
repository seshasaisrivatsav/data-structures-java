package arraysAndStrings;

public class RotateArrayJuggling {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8};
		int rTimes=2;
		
		int[] res = rotateArray(A, rTimes);
		
		for(int i=0; i<res.length;i++) {
			System.out.print(res[i]+ " ");
		}
		
		
		
	}
	
	
	public static int[] rotateArray(int[] A, int rotate) {
		int j, k, temp;
		for (int i = 0; i < gcd(rotate, A.length); i++) {
			/* move i-th values of blocks */
			temp = A[i];
			j = i;
			while (1 != 0) {
				k = j + rotate;
				if (k >= A.length)
					k = k - A.length;
				if (k == i)
					break;
				A[j] = A[k];
				j = k;
			}
			A[j] = temp;
		}
		return A;
	}
	
	/*
	 * Euclid's algorithm
	 * gcd(a,0)=a
	 * gcd(a,b) = gcd(b, a%b)
	 */
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}
}
