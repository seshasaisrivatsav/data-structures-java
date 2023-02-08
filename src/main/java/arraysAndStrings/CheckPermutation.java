package arraysAndStrings;

import java.util.Arrays;

/**
 * Source: Cracking the Coding Interview (C.T.C.I)
 * Given two strings write a method to decide if one is a permutation of the other
 *  Assumptions
 *      - Two strings are permutations IFF they've same characters
 *      - Ask interviewer for case sensitivity
 *      - Check if we need to disregard spaces
 *  Approach 1: Build a character count array based on string 1 and decrement the count in it from string 2 and return
 *              false if the count is less than 0
 *  Approach 2: Sort both strings and compare them. (Complex as some sorts might take n2 and we need more memory)
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutationSortApproach("ab v d ", "d v ba"));
    }

    /**
     * Given two strings, we convert
     *      Time Complexity: O(n)
     *      Space Complexity: O(n)
     * @param str1 String
     * @param str2 String
     * @return boolean
     */
    public static boolean isPermutation_optimal(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] str1_chars = str1.toCharArray();

        // Create an int array where each position represents the character and the value represents character count
        int[] characterCount = new int[256]; // Assuming there are 256 ASCII characters

        // Count the number of characters in str1
        for (char c: str1_chars) {
            characterCount[c]++;
        }

        for (int i=0; i<str2.length(); i++) {
            int str2Char = str2.charAt(i);
            characterCount[str2Char]--;
            if (characterCount[str2Char] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time Complexity O(n log(n))
     *           Sort takes - O(n log(n))
     *           String equals - O(n)
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isPermutationSortApproach(String str1, String str2) {
        str1 = str1.replaceAll("\\s", ""); // Replace all spaces
        str2 = str2.replaceAll("\\s", ""); // Replace all spaces
        if (str1.length() != str2.length()) {
            return false;
        }
        return sortString(str1).equals(sortString(str2));
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
