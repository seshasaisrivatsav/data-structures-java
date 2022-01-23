package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic
 * Isomorphic: if characters in s can be replaced to get t
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters
 * No Two characters may map to same character, but a character may map to itself
 *
 *  Example 1:
 *      Input: s = "egg", t = "add"
 *      Output: true
 *
 *  Example 2:
 *      Input: s = "foo", t = "bar"
 *      Output: false
 *
 * Example 3:
 *      Input: s = "paper", t = "title"
 *      Output: true
 *
 * Companies Asked: LinkedIn, Amazon, Google, Uber
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println("Expected: true " + isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println("Expected: false " + isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println("Expected: true " + isomorphicStrings.isIsomorphic("paper", "title"));
        System.out.println("Expected: false " + isomorphicStrings.isIsomorphic("badc", "baba"));
    }

    /**
     * Approach: Character Mapping with dictionary
     *          - We will process both of the strings from left to right
     *          - At each step, we take one character at a time from each string say c1, c2 from s and t
     *              - if the characters don't have a mapping, we add one in the dictionary and move on to next character
     *               - now we expect mapping_s_t[c1] = c2 and mapping_t_s[c2] = c1
     *               - if that's not the case, return false
     *          Eg: badc, baba
     *              mapping_s_t
     *              b - b
     *              a - a
     *              d - b
     *              c - a  => here we've mapped everything, but just can't return
     *              mapping_t_s
     * @param s String s
     * @param t String t
     * @return true if the strings are isomorphic
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { return false; }
        if (s.equals(t)) { return true; }

        // Step 1: Initialize two maps, with -1
        int[] sToTMap = new int[256];
        Arrays.fill(sToTMap, -1);
        int[] tToSMap = new int[256];
        Arrays.fill(tToSMap, -1);

        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case - when both dictionaries don't have the value, add it
            if (sToTMap[c1] == -1 && tToSMap[c2] == -1) {
                sToTMap[c1] = c2;
                tToSMap[c2] = c1;
            } else if (sToTMap[c1]!=c2 || tToSMap[c2]!=c1) {
                // Case - When the dictionaries have the values and don't match, return false
                return false;
            }
        }
        return true;
    }
}
