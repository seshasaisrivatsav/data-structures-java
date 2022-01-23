package arraysAndStrings;

/**
 * Amazing String: A string s is said to be Amazing if no two adjacent characters in the string are the same.
 * For example, "a", "ab" "abab", "abcbcb" are all Amazing strings
 * 				"abb", "aabb", "abcdeebdcc" are all not Amazing.
 */
public class AmazingStrings {
    public static void main(String[] args) {
        System.out.println(amazingCheck("aaaabbccd"));
        System.out.println(amazingCheck("aabbaac"));
        System.out.println(amazingCheck("abaaaba"));
        System.out.println(amazingCheck("aaab"));
        System.out.println(amazingCheck("aabb"));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Approach: Compare curr and next character, if they're the same increment the char
     * @param s String
     * @return int representing swaps needed
     */
    public static int amazingCheck(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
        }
        return count;
    }
}
