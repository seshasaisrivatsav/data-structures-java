package arraysAndStrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Return the length of longest substring without repeating characters
 * abcdabcgab = abcd, bcda, cda, bcgab = 5
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *  Companies: Amazon, MS, FB, Adobe, Google, Apple, Salesforce
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_bruteForce("abcabcbb"));
        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_slidingWindow_n2("abcabcbb"));
        System.out.println("Expected 4. Actual :" + getLongestSubstringLength_slidingWindow_n2("abcabcdad"));
        System.out.println("Expected 9. Actual :" + getLongestSubstringLength_slidingWindow_n2("abcdeefghijabc"));
        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_slidingWindow_n("abcabcbb"));
        System.out.println("Expected 9. Actual :" + getLongestSubstringLength_slidingWindow_n("abcdeefghijabc"));
        System.out.println("Expected 3. Actual :" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Expected 9. Actual :" + lengthOfLongestSubstring("abcdeefghijabc"));
        System.out.println("Expected: gabcelm Actual: " + getLongestSubstring("abcdabcgabcelma"));
    }

    /**
     * Approach 1: Using window sliding, the problem can be solved in linear time
     * Whenever we see a repetition, we move the window till the repeated string
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param str String
     * @return int length of longest substring string
     */
    public static int getLongestSubstringLength_slidingWindow_n(String str) {
        if (str.isEmpty()) { return 0; }
        if (str.length()==1) { return 1; }

        String temp = "";  // Initialize temp to ""
        int maxLength = 0;

        /*
            abcabcbb temp  = "", ml=-1
            temp = a, ml = 1
            temp = ab ml = 2
            temp = abc ml = 3
            temp = bc
                   bca ml = 3
         */
        for (char c: str.toCharArray()) {
            String curr = String.valueOf(c); // For each String character in given string

            if (temp.contains(curr)) { // If the temp string contains(curr), we cut the string until that, using substring
                temp = temp.substring(temp.indexOf(curr) + 1); // sliding
            }
            temp = temp + curr; // and add current string to temp // The compiler would convert this + to use string builder and it generates same bite code
            maxLength = Math.max(temp.length(), maxLength);
        }
        return maxLength;
    }

    /**
     * Approach: using Hashmap to store last occurred position
     * @param s String
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        // Creating a set to store the last positions of occurrence
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;

        // starting the initial point of window to index 0
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            // Checking if we have already seen the element or not
            if (seen.containsKey(s.charAt(end))) {
                // If we've already seen the character, move the start pointer  to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }

            // Updating the last seen value of the character
            seen.put(s.charAt(end), end);
            maximum_length = Math.max(maximum_length, end - start + 1);
        }
        return maximum_length;
    }

    /**
     * Window sliding with
     *  Time Complexity: O(n^2)
     * @param str String
     * @return int length of longest substring
     */
    public static int getLongestSubstringLength_slidingWindow_n2(String str) {
        if (str.isEmpty()) return 0;
        int res = 0;
        for (int i=0; i<str.length(); i++) {
            boolean[] visited = new boolean[256];
            for (int j=i; j<str.length(); j++) {
                if (visited[str.charAt(j)]) { // If we already found it, break the current loop and mark this character as false for next iteration
                    break;
                } else {
                    visited[str.charAt(j)] = true;
                    res = Math.max(res, j-i+1);
                }
            }
            visited[str.charAt(i)]=false; // since the window moved, mark the previous one as false
        }
        return res;
    }
    /**
     * Time complexity: O(n^3) - two for loops - n2 + search in string n = n^3
     * @param str String
     * @return int
     */
    public static int getLongestSubstringLength_bruteForce(String str) {
        String res = "";
        int max = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++) {
            res = "";
            for(int j=i; j<str.length(); j++) {
                if (res.contains(String.valueOf(str.charAt(j)))) {
                    break; // breaks the loop
                }
                res = res + str.charAt(j);
                max = Math.max(res.length(), max);
            }
        }
        return max;
    }

    // TODO: Fix this
    public static String getLongestSubstring(String str) {
        if (str.isEmpty() || str.length() ==1 ) { return str; }
        int startIndex=0; int endIndex=0;
        String temp = "";
        int maxLength = 0;

        /*
            abcabcbb temp  = "", ml=-1
            temp = a, ml = 1
            temp = ab ml = 2
            temp = abc ml = 3
            temp = bc
                   bca ml = 3
         */

        for (int i=0; i < str.length(); i++) {
            String curr = String.valueOf(str.charAt(i));
            if (temp.contains(curr)) { // If the temp string contains(curr), we cut the string until that, using substring
                startIndex = startIndex+1;
                temp = temp.substring(temp.indexOf(curr) + 1);

            }
            temp = temp + curr; // and add current string to temp // The compiler would convert this + to use string builder and it generates same bite code
            if (temp.length() > maxLength) {
                maxLength = temp.length();
                endIndex = i;
            }

        }
        return str.substring(startIndex, endIndex+1);
    }
}
