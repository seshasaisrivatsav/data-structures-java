package general;

import java.util.Scanner;

public class ReverseNumber {
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		System.out.println("ENter a number");
		int i = sc.nextInt();
		
		
		System.out.println(reverseNumber(i));
		
		
	}
	
	//The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
	
	public static int reverseNumber(int x) {
		 
		  
        long newX = x;
        Boolean isNegative=false;
        long res = 0;
        
        
        if(newX <0){
            newX = 0 - newX;
            isNegative = true;
        }
       
	
        
        while(newX!=0){
            res = (res*10)+(newX%10);
            newX = newX/10;
        }
        
        if(res > Integer.MAX_VALUE) return 0;
        
        if(isNegative){
            return -1 * (int)res;
        }else{
            return (int)res;
        }
        
	}

}
