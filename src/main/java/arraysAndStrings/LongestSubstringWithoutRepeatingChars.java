package arraysAndStrings;

/**
 * Return the length of longest substring without repeating characters
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

        System.out.println(getLongestSubstringLength_bruteForce("abcabcbb")); // 3
    }

    public static int getLongestSubstringLength_bruteForce(String str) {
        String res = "";
        int max = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++) {
            res = "";
            for(int j=i; j<str.length(); j++) {
                if (stringHasChar(res, str.charAt(j))) {
                    break;
                }
                res = res + str.charAt(j);
                if (res.length() > max) {
                    max = res.length();
                }
            }
        }
        return max;
    }

    private static boolean stringHasChar(String s, char c) {
        for (char ch: s.toCharArray()) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }
}
