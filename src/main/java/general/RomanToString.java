package general;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToString {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("ENter a roman Number");
		String i = sc.nextLine();
		
		
		System.out.println(romanToString(i));
		
		
	}
	
	public static int romanToString(String i) {
		int res=0;
		char[] roman;
		roman = i.toCharArray();
		
		HashMap<Character, Integer> values = new HashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);
		
		
		for(int a=0; a<roman.length-1; a++) {
			if(values.get(roman[a]) >= values.get(roman[a+1])) {
				res += values.get(roman[a]);
			} else {
				res -= values.get(roman[a]);
			}
			
			
		}
		res += values.get(roman[roman.length - 1]);
		
		return res;
	}

}
