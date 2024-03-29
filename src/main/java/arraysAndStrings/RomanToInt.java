package arraysAndStrings;

import java.util.HashMap;

public class RomanToInt {
	public static void main(String[] args) {
		System.out.println("III = 3: Output: " + romanToString("III"));
		System.out.println("LVIII = 58: Output: " + romanToString("LVIII"));
		System.out.println("MCMXCIV = 1994: Output: " + romanToString("MCMXCIV"));

		System.out.println("III = 3: Output: " + romanToStringFast("III"));
		System.out.println("LVIII = 58: Output: " + romanToStringFast("LVIII"));
		System.out.println("MCMXCIV = 1994: Output: " + romanToStringFast("MCMXCIV"));
	}


	static HashMap<String, Integer> romanMap = new HashMap<>();
	static {
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);

		romanMap.put("IV", 4);
		romanMap.put("IX", 9);
		romanMap.put("XL", 40);
		romanMap.put("XC", 90);
		romanMap.put("CD", 400);
		romanMap.put("CM", 900);
	}

	/**
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * Algorithm
	 * 	- We take a pointer and as long as it is less than the string length we iterate through it
	 * 			- if i < str.length() -1 (this is used to check two characters) then we get map value and move i by 2 and continue to next iteration
	 * 		  - if double sybmol doesn't exist we get i to i+1 sub string and increment i by 1
	 * @param str string representing Roman number
	 * @return integer represent decimal
	 */
	public static int romanToStringFast(String str) {
		int res=0;
		int i=0;
		while (i<str.length()) {
			if (i < str.length()-1) {
				String doubleSymbol = str.substring(i, i+2);
				if (romanMap.containsKey(doubleSymbol)) {
					res += romanMap.get(doubleSymbol);
					i = i+2;
					continue;
				}
			}
			res = res + romanMap.get(str.substring(i, i+1));
			i++;
		}
		return res;
	}

	/**
	 * Approach 2
	 * @param str String
	 * @return int
	 */
	public static int romanToString(String str) {
		int res=0;
		HashMap<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		for (int i=0; i<str.length()-1; i++) {
			if (romanMap.get(str.charAt(i)) >= romanMap.get(str.charAt(i+1))) {
				res += romanMap.get(str.charAt(i));
			} else {
				res -= romanMap.get(str.charAt(i));
			}
		}
		res += romanMap.get(str.charAt(str.length()-1));
		return res;
	}

}
