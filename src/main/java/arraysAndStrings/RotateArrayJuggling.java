package arraysAndStrings;

import java.util.Arrays;

public class RotateArrayJuggling {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int rTimes=2;
		System.out.println(Arrays.toString(rotateArray(arr, rTimes)));
	}
	
	
	public static int[] rotateArray(int[] arr, int rotate) {
		int j, k, temp;
		for (int i = 0; i < gcd(rotate, arr.length); i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (1 != 0) {
				k = j + rotate;
				if (k >= arr.length)
					k = k - arr.length;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		return arr;
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
