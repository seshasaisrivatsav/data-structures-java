package arraysAndStrings;

/**
 *
 * Leetcode:
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class IndexOfStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return -1;
        for (int i=0; i<haystack.length();i++) {
            if (i+needle.length() > haystack.length()) {
                // We run into this case when
                /*
                    0 1 2 3 4 5 6 7 8 9 10
                    m i s s i s s i p p i       <= Haystack
                                  ^

                    0 1 2 3 4 5
                    i s s i p i                 <= Needle

                    i+needleLength > haystacklength
                    7+6 > 11
                    13>11

                 */
                return -1;
            }
            for (int j=0; j<needle.length(); j++) {
                if (needle.charAt(j)!=haystack.charAt(i+j)) {
                    break;
                }
                if (j==needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
