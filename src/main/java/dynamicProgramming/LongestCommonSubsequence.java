package dynamicProgramming;

/**
 *
 * Problem Statement:
 *      Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *      A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * Example:
 *      "ace" is a subsequence of "abcde".
 *      A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *      Example 0
 *          actga (has tga)
 *          gzyat (has gat) => No subsequence
 *
 *      Example 1:
 *          Input: text1 = "abcde", text2 = "ace"
 *          Output: 3
 *          Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 *      Example 2:
 *          Input: text1 = "abc", text2 = "abc"
 *          Output: 3
 *          Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 *      Example 3:
 *          Input: text1 = "abc", text2 = "def"
 *          Output: 0
 *          Explanation: There is no such common subsequence, so the result is 0.
 *
 * Leetcode: https://leetcode.com/problems/longest-common-subsequence/
 *
 * Dynamic Programming Approach:
 *      Given: str1 and str2
 *      i = pointer that follows str1
 *      j = pointer that follows str2
 *
 * LCS[i][j] = Longest common subsequence at ith and jth index
 *              / 1 + LCS[i-1][j-1] if str1[i] == str2[j]
 * LCS[i][j] = {
 *              \ Max(LCS[i-1, j], LCS[i, j-1]) if str1[i] != str2[j]
 *
 * Use case:
 *  - Useful for checking dit diff
 *  Used in genetic analysis
 * Companies: Amazon, Bloomberg, Adobe, Doordash
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println("Expected: 3 " + getLongestCommonSubsequenceLength("abcde", "ace"));
        System.out.println("Expected: 3 " + getLongestCommonSubsequenceLength("abc", "abc"));
        System.out.println("Expected: 0 " + getLongestCommonSubsequenceLength("abc", "def"));
    }

    /**
     * Approach 1: with dynamic programming with formula written above
     *
     * Time Complexity: O(MN)
     * Space Complexity: O(MN)
     * @param str1 String str1
     * @param str2  String str1
     * @return int longest common subsequence length
     */
    public static int getLongestCommonSubsequenceLength(String str1, String str2) {
        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];
        int lcsMaxLength = 0;
        for (int i=0; i<=str1.length(); i++) {
            for (int j=0; j<=str2.length(); j++) {
                if (i==0 || j==0) {
                    lcs[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }

                lcsMaxLength = Math.max(lcsMaxLength, lcs[i][j]);
            }
        }

        return lcsMaxLength;
    }
}
