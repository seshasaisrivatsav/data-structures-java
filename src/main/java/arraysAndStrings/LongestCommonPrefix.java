package arraysAndStrings;

/**
 * Leetcode: longest common prefix (LCP)
 * Write a function to find the longest common prefix string amongst an array of strings.
 * https://en.wikipedia.org/wiki/LCP_array
 * https://www.interviewbit.com/blog/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println("Expected: fl : actual: "+ lcp_verticalScanning(strs));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println("Expected:  : actual: "+ lcp_verticalScanning(strs2));

        System.out.println("Expected: fl : actual: "+ lcp_horizontalScanning(strs));

        System.out.println("Expected:  : actual: "+ lcp_horizontalScanning(strs2));
    }

    /**
     * Vertical Scanning we compare characters from top to bottom of ith index for each string
     * Efficient approach when LCP string is small
     *
     * Algorithm
     *      - Iterate through String1 from S1 to SN
     *      - Start by comparing 0th index, 1st index and ith index simultaneously for each string
     *          - if any characters don't match, return LPS(1,i)
     *          - else continue and after scanning of N strings, LPS(s1..Sn) is found
     *
     * Time Complexity: O(K) where K = sum of characters in all strings
     * Space Complexity: O(1)
     * @param strings String[]
     * @return string lcp
     */
    public static String lcp_verticalScanning(String[] strings) {
        if (strings.length == 0) return "";
        for (int i=0; i<strings[0].length(); i++) { // Iterate through String1
            char c = strings[0].charAt(i);
            for (int j=1; j<strings.length; j++) { // Iterate from String2 to StringN
                if ((i== strings[j].length()) || (strings[j].charAt(i) != c)) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0];
    }
    /**
     * LCP (S1.... Sn) =LCP(  LCP( LCP(S1, S2), S3), .... SN)
     * Algorithm
     *      - Iterate from S1 to Sn
     *      - For ith iteration LCP (S1...Si) can be obtained
     *      - If LCP is empty string, exit early and return empty string
     *      - Else continue
     * @param strings
     * @return
     */
    public static String lcp_horizontalScanning(String[] strings) {
        if (strings.length==0) return "";
        String lcp = strings[0];
        for (int i=1; i<strings.length; i++) {
            while (strings[i].indexOf(lcp) != 0) {
                lcp = lcp.substring(0, lcp.length()-1);
                if (lcp.isEmpty()) {
                    return "";
                }
            }
        }
        return lcp;
    }

    /**
     * Other approaches : Binary Search
     * https://www.interviewbit.com/blog/longest-common-prefix/
     */

}
