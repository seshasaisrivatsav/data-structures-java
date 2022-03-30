package dynamicProgramming;

/**
 *
 * Problem: Find longest string that is a substring of two or more strings
 *
 * Usages: In data deduplication and plagiarism detection
 *         data deduplication = technique for eliminating duplicate copies of repeating data
 *
 * Examples:
 *      Input : X = “abcdxyz”, y = “xyzabcd”
 *      Output : 4
 *      Explanation:
 *      The longest common substring is “abcd” and is of length 4.
 *
 *      Input : X = “zxabcdezy”, y = “yzabcdezx”
 *      Output : 6
 *      Explanation:
 *      The longest common substring is “abcdez” and is of length 6.
 *
 * Dynamic Programming Approach: (bottom up approach)
 *  Given: str1 and str2
 *         i = pointer that follows str1
 *         j = pointer that follows str2
 *
 *   We keep track of maximum value obtained so far
 *   LCS[i][j] = Longest Common Substring at ith and jth indices
 *
 *
 *              /   0                       if i==0 or j==0
 *   LCS[i][j] {    1 + LCS[i-1][j-1]       if str1[i] == str2[j] && i, j > 0
 *              \   0                       if str1[i] != str2[j] && i, j > 0
 *
 *
 * Resources:
 *      https://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/
 *      https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *      https://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 * video: https://www.youtube.com/watch?v=BysNXJHzCEs&ab_channel=TusharRoy-CodingMadeSimple
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println("Expected: 4. Actual: " + getLongestCommonSubstringLength("abcdxyz", "xyzabcd"));
        System.out.println("Expected: 6. Actual: " + getLongestCommonSubstringLength("zxabcdezy", "yzabcdezx"));
        System.out.println("Expected: 8. Actual: " + getLongestCommonSubstringLength("dynamictutorialProgramming", "tutorialhorizon"));
        System.out.println("Expected: 8. Actual: " + getLongestCommonSubstringLength("tutorialhorizon", "dynamictutorialProgramming"));

        System.out.println("Expected: abcd. Actual: " + getLongestCommonSubstring("abcdxyz", "xyzabcd"));
        System.out.println("Expected: abcdez. Actual: " + getLongestCommonSubstringLength("zxabcdezy", "yzabcdezx"));
        System.out.println("Expected: 8. Actual: " + getLongestCommonSubstringLength("dynamictutorialProgramming", "tutorialhorizon"));
        System.out.println("Expected: 8. Actual: " + getLongestCommonSubstringLength("tutorialhorizon", "dynamictutorialProgramming"));
    }

    /**
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * @param str1 String
     * @param str2 String
     * @return int maxLength of longest common substring
     */
    public static int getLongestCommonSubstringLength(String str1, String str2) {
        int[][] lcs = new int[str1.length()+1][str2.length()+1];
        int lcsMaxLength = 0;

        for(int i=0; i<=str1.length(); i++) {
            for (int j=0; j<=str2.length(); j++) {
                if (i==0 || j==0) {
                    lcs[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                    lcsMaxLength = Math.max(lcsMaxLength, lcs[i][j]);
                } else {
                    lcs[i][j] = 0;
                }
            }
        }

        return lcsMaxLength;
    }


    /**
     * In order to print the value, find the max value and strart traversing from that element
     * and move i--, j-- diagonally up until we reach zero
     * @param str1 String str1
     * @param str2 String str2
     * @return String longest common substring
     */
    public static String getLongestCommonSubstring(String str1, String str2) {
        int[][] lcs = new int[str1.length()+1][str2.length()+1];
        int lcsMaxLength = 0;
        int endIndex = 0;
        for(int i=0; i<=str1.length(); i++) {
            for (int j=0; j<=str2.length(); j++) {
                if (i==0 || j==0) {
                    lcs[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                    if (lcs[i][j] > lcsMaxLength) {
                        lcsMaxLength = lcs[i][j];
                        endIndex = i;
                    }

                } else {
                    lcs[i][j] = 0;
                }
            }
        }

        return str1.substring(endIndex-lcsMaxLength, lcsMaxLength);
    }
}
