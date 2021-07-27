package general;

import java.util.Scanner;

public class CheckPalindromeNoSpace {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		System.out.println("ENter a number");
		int i = sc.nextInt();
		
		
		System.out.println(checkPal(i));
		
		
	}
	
	
	public static boolean checkPal(int i) {
		Boolean a=false;
		
		int res=0;
		int orig =i;
		
		while(i!=0) {
			res = (res*10) + (i%10);
			i=i/10;
		}
		
		if(orig==res) {
			return true;
		}
		
		return a;
	}
}
