package arraysAndStrings;
/*
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 *
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */

public class ConvertLettersToNumbersLikeExcel {

	public static void main(String[] args) {
		System.out.println("Expected 1: Actual: " + titleToNumber("A"));
		System.out.println("Expected 27: Actual: " + titleToNumber("AA"));
		System.out.println("Expected 28: Actual: " + titleToNumber("AB"));
		System.out.println("Expected 701: Actual: " + titleToNumber("ZY"));
		System.out.println("Expected 1: Actual: " + titleToNumber_alt("A"));
		System.out.println("Expected 27: Actual: " + titleToNumber_alt("AA"));
		System.out.println("Expected 28: Actual: " + titleToNumber_alt("AB"));
		System.out.println("Expected 701: Actual: " + titleToNumber_alt("ZY"));
		System.out.println("Expected 35831: Actual: " + titleToNumber_alt("AZZC"));
	}

	/**
	 * TC: O(N)
	 * SC: O(1)
	 * Eg:
	 * ZY
	 * Z-A
	 * Explanation:
	 * Eg: AZZC
	 * 		1. 	C
	 * 			= 3 * 26 ^ 0 = 3
	 * 		2.  ZC
	 * 			= 26*26^1 + 3 = 676 + 3 = 679
	 * 		3. ZZC
	 * 			= 26*26^2 + 679 = 18255
	 * 		4. AZZC
	 * 			= 26*26^3 + 18255 = 35831
	 * @param s
	 * @return
	 */
	public static int titleToNumber_alt(String s) {
		int res = 0;
		for (char c : s.toCharArray()) {
			res = res * 26;
			res = res + (c - 'A' +1);
		}
		return res;
	}

	public static int titleToNumber(String s) {
		char[] chars = s.toCharArray();
		int res = 0;
		int toInt;
		for (char c : chars) {
			toInt = (int) c - 64;
			res = res * 26 + toInt;

		}
		return res;
	}
}
