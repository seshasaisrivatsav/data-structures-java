package arraysAndStrings;

import java.util.HashMap;
import java.util.Scanner;
/*
 * Return first non repeated character from a string
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String input = sc.next();

		System.out.println(firstNonRepeatedChar_hashmap(input));

	}

	/**
	 * Return index of first non repeated char
	 * Approach: Use a char array of size 26
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * @param str String
	 * @return int of first non repeating char
	 */
	public static int firstNonRepeatedChar_arr(String str) {
		if(str.length()==0) {return -1;}
		if(str.length()==1) {return 0;}
		int[] chars = new int[26];
		for (int i=0; i<str.length(); i++) {
			chars[str.charAt(i)-'a']++;
		}
		for (int i=0; i<str.length(); i++) {
			if (chars[str.charAt(i)-'a'] == 1) { return i;}
		}
		return -1;
	}

	/**
	 * Approach: Hashmap of char counts and iterate again to find the first non repeated
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * @param input String
	 * @return char first non repeated char
	 */
	public static char firstNonRepeatedChar_hashmap(String input) {
		// Store the string in a HashMap
		HashMap<Character, Integer> inputHM = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			// If HM already has a character
			if (inputHM.containsKey(input.charAt(i))) {
				inputHM.put(input.charAt(i), 1+inputHM.get(input.charAt(i)));
			} else {
				// first character addition
				inputHM.put(input.charAt(i), 1);
			}
		}

		// Iterate through string
		for (int i = 0; i < input.length(); i++) {
			if (inputHM.get(input.charAt(i)) == 1) {
				return input.charAt(i);
			}
		}
		
		return '0';

	}

}
