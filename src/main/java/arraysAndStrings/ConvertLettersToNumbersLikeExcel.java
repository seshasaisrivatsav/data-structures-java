package arraysAndStrings;

public class ConvertLettersToNumbersLikeExcel {
	/*
	 * Given a column title as appear in an Excel sheet, return its corresponding
	 * column number.
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 */
	public static void main(String[] args) {
		System.out.println(titleToNumber("BB"));
	}

	public static int titleToNumber(String s) {
		
		char[] ch=s.toCharArray();
		int res=0;
		int toInt=0;
		int j = ch.length - 1; 
		for(int i=0; i<ch.length; i++) {
			toInt = (int) ch[i] - 64;
			 res = res* 26 + toInt;
			
		}
		return res;
	}
}
