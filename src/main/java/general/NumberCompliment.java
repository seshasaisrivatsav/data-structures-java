package general;

import java.util.Scanner;

public class NumberCompliment {
	/*
	 * Given a number, convert it into bit, ignore 0s and invert bits and convert it
	 * back into number
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer");
		int input = sc.nextInt();
		System.out.println(compliment(input));
	}

	public static int compliment(int in) {

		// METHOD 1
//		int ones = (Integer.highestOneBit(in) << 1) - 1;
//		return in ^ ones;

		// METHOD 2
		// Convert integer to binary
		String binaryString = Integer.toBinaryString(in);
		
		String res = "";
		for(char c: binaryString.toCharArray()) {
			if(c=='0') {
				res +='1';
			}else {
				res +='0';
			}
		}

		// Convert binary into integer
		int complement = Integer.parseInt(res, 2);
		return complement;
	}
}
