package arraysAndStrings;

/**
 * Given two strings s1 and s2 write code to check if s2 is a rotation of s1 using only one call to `isSubstring`
 * `isSubstring` => Assume you've this method to check if a word is a substring of another
 *
 * [Solution Article](https://medium.com/@jschapir/cracking-the-coding-interview-is-string-2-a-rotated-version-of-string-1-a02c9ec81f58)
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isSubstring("abcdefg", "bcd"));
    }

    /**
     * Approach: subString(string1+string1, string2) = true
     *  if we concatenate string 1 with itself the new larger string MUST contain string2 in order for string 2 to be a rotation of string 1
     *
     *  Time Complexity: O(N) - Depends on runtime of isSubstring
     *  Space Complexity: O(1)
     * @param s1 String
     * @param s2 String
     * @return true if s2 is a rotation of s1
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        // s1 is rotation of s2 if s2 is a substring of s1+s1
        return isSubstring(s1+s1, s2);
    }



    /**
     *
     * Time complexity: O(M+N) = O(N)
     * Space complexity: O(1)
     *
     * NOTE: This is not part of the problem
     * Method that checks if a string is a substring of another
     *
     *  Steps
     *      - We iterate through longer string and maintain a pointer for smaller string from 0th index
     *      - For each iteration we compare current character in longer string with pointer of smaller string
     *      - if they match we increment the pointer on smaller string by 1. if they don't match we set pointer back to zero
     *      - finally if smaller string's pointer value = length of it, then return true
     *      -
     * @param s1 String
     * @param s2 String
     * @return boolean
     */
    public static boolean isSubstring(String s1, String s2) {
        String temp;

        // NOTE: MAKE S1 LONGER, S2 SHORTER
        if (s2.length() > s1.length()) {
            temp = s2;
            s2 = s1;
            s1 = temp;
        }


        // iterate through LONGER string
        int smallStringPointer = 0;
        for (int i=0; i<s1.length(); i++) { // S1 = Longer String
            if (smallStringPointer == s2.length()) { // S2 = Smaller String
                return true;
            }
            if (s2.charAt(smallStringPointer) == s1.charAt(i)) {
                smallStringPointer++;
            } else {
                // VVIP: Move i back to the distance until which we found and broke character
                // lets say str1 = ppabcdefabcz and str2: abcz, shift i by i-smallStringPointer
                // at i=5 we run into case where smallStringPointer=3, then we move i to i-smallPointer i.e, we move it to 2,
                // so that in next iteration it goes to 3, so we essentially start from 'bcdefabcz' in next iteration
                // NOTE: if we make i=x, in next iteration i value will be i+1
                if (smallStringPointer > 0) {
                    i = i-smallStringPointer;
                }
                smallStringPointer = 0;
            }
        }
        return smallStringPointer == s2.length();
    }
}
