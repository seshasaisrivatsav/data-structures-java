package dynamicProgramming;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Given a string, return the longest palindromic substring in it
 * From Leetcode: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(getLongestPalindromicSubstring("aaaabbaa"));
        System.out.println("Expected: bab or aba" + getLongestPalindromicSubstring("babad"));
        System.out.println("Expected: bb" + getLongestPalindromicSubstring("cbbd"));
        System.out.println("Expected: a" + getLongestPalindromicSubstring("a"));
        System.out.println("Expected: ac" + getLongestPalindromicSubstring("ac"));
    }

    /**
     * Uses Dynamic Programming
     *      P(i,j) = true, if SubString Si...Sj is a palindrome
     *             = false, otherwise
     *
     *      Therefore, P(i, j) = ( P(i+1, j-1) && Si == Sj)
     *
     *      Base Cases
     *          1. P(i,i) = true
     *          2. P(i, i+1) == (Si == Si+1)
     *
     *
     *
     * <a href="file:../../../notes/DynamicProgramming.md" Dynamic Programming</a>
     *
     * https://youtu.be/UflHuQj6MVA
     * @param str String
     * @return String longest palindromic substring
     */
    public static String getLongestPalindromicSubstring(String str) {
        if (str.length() == 0) { return ""; }
        int[][] refMatrix = new int[str.length()][str.length()]; // rows represent start index, cols rep end index

        // Every element is a palindrome
        for (int i=0; i<str.length(); i++) {
            refMatrix[i][i]=1;
        }

        // Below logic is for 2 or more
        int startIndex = 0;
        int maxPalindromeLength = 1;

        // 2 letter substrings
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                refMatrix[i][i+1] = 1;
                startIndex = i;
                maxPalindromeLength = 2;
            }
        }

        /*
            Do the below logic when str.length > 3
            P(i, j) = ( P(i+1, j-1) && Si==Sj)
            V.V.I.P - Do all 3 length strings first, then 4 length strings

            Eg:
            For string of length = 8 (aaaabbaa |01234567)
            3 - (0,2), (1,3), (2,4), (3,5), (4,6), (5,7)
            4 - (0,3), (1,4), (2,5), (3,6), (4,7)
            5 - (0,4), (1,5), (2,6), (3,7)
            6 - (0,5), (1,6), (2,7)
            7 - (0,6), (1,7)
            8 - (0,7)
         */
        for (int j=3; j<=str.length(); j++) { // V.V.I.P = First goes j, helps determine the length
            for (int i=0; i<str.length()-j+1; i++) { // V.V.I.P = second goes i
                int col = (i+j)-1;
                if (refMatrix[i+1][col-1] == 1 &&str.charAt(i) == str.charAt(col)) {
                    refMatrix[i][col] = 1;
                    if (j > maxPalindromeLength) {
                        maxPalindromeLength = j;
                        startIndex = i;
                    }
                }
            }
        }

        return str.substring(startIndex, startIndex+maxPalindromeLength);

    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        int count = 0;
        int strLength = str.length();
        while(count < strLength/2) {
            if (str.charAt(count)!=str.charAt(strLength - 1 - count)) {
                return false;
            }
            count ++;
        }
        return true;
    }
}
