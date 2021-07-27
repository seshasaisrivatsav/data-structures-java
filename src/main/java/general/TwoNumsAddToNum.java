package general;
import java.util.HashSet;
import java.util.Scanner;

public class TwoNumsAddToNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number");
		int i = sc.nextInt();
		int[] A = {1,9,3,4,5,11};
		System.out.println(check(i, A));
	}
	
	public static boolean check (int i, int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		for(int a=0; a<A.length;a++) {
			if(hs.contains(i-A[a])) {
				return true;
			}
			hs.add(A[a]);
		}
		return false;
	}
}
