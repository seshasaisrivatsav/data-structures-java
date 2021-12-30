package arraysAndStrings;

public class DeleteCharactersToMakeStringsAnagrams {

	public static void main(String[] args) {
		String a = "abcadeh";
		String b = "hea";
		System.out.println(numberNeeded(a, b));
	}

	public static int numberNeeded(String first, String second) {
		int res = 0;
		int[] str1 = new int[26], str2 = new int[26];
		
		 
		// Iterate through first string and add to str1
		for(int i=0; i<first.length(); i++) {
			str1[first.charAt(i)-'a']++;
		}
		
		// Iterate through second string and add to str2
		for(int i=0; i<second.length(); i++) {
			str2[second.charAt(i)-'a']++;
		}
		
		// return the difference
		for(int i=0; i<26; i++) {
			res +=Math.abs(str1[i]-str2[i]);
		}
		
		return res;

	}

}
