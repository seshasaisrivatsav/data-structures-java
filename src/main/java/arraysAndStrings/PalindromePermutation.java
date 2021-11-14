package arraysAndStrings;

import java.util.HashMap;

/**
 * Given a string write a function to check if it's a permutation of a palindrome
 *
 * Palindrome = word/phrase that is same forwards and backwards
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(palindromePermutation_hashmap("appa"));
    }

    /**
     * Approach : Converts the given string into a hashmap excluding spaces
     *           We iterate over hashmap values keeping count of the number of times we saw an odd number
     *           If we see an odd number more than once, it's not a palindrome
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param str String
     * @return boolean representing if the given number is palindrome
     *
     * // TODO: Improvements - ignore `'`, ','  , '?'
     */
    public static boolean palindromePermutation_hashmap(String str) {
        HashMap<Character, Integer> stringCount = new HashMap<Character, Integer>();
        for (char c: str.toCharArray()) {
            if (c != ' ') {
                if (stringCount.containsKey(c)) {
                    stringCount.put(c, stringCount.get(c)+1);
                } else {
                    stringCount.put(c, 1);
                }
            }
        }

        int odds = 0;
        for (Integer counts: stringCount.values()) {
            // Increment odds count if we find one
            if (counts%2 != 0) {
                odds ++;
            }
            if (odds > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromePermutation_iterate(String str) {
        if (str.length() == 1) {
            return true;
        }
        String str1 = str.replaceAll("\\s", "");
        for (int i=0; i<str1.length()/2; i++) {
            if (str1.charAt(i) != str1.charAt(str1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
