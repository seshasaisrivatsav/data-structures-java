package general;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {
	/*
	 * Return first non repeated character from a string
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String input = sc.next();

		System.out.println(firstNonRepeated(input));

	}

	public static char firstNonRepeated(String input) {
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
