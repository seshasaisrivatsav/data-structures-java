package arraysAndStrings;

/**
 * Given a string write a function to check if it's a permutation of a palindrome
 *
 * Palindrome = word/phrase that is same forwards and backwards
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println("expected: true actual: " + palindromePermutation_iterate("aa"));
        System.out.println("expected: false actual: " + palindromePermutation_iterate("abb"));
        System.out.println("expected: true actual: " + checkPalindrome_string_ignoreSpecialCharsOof1("red rum, sir, is murder"));
        System.out.println("expected: true actual: " + checkPalindrome_string_ignoreSpecialCharsOof1("A man, a plan, a canal: Panama"));
    }

    /**
     * Approach:
     *  - Have two pointers one from head, one from tail.
     *  - as long as head <= tail
     *      - we get each char and only if that character is a letter or digit, we compare and move pointer towards
     *          - if no match, we return false
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     *  Note: The method ignores special characters
     *        The method is case insensitive
     *
     * @param s String
     * @return boolean true if the string is palindrome
     *
     */
    public static boolean checkPalindrome_string_ignoreSpecialCharsOof1(String s) {
        if (s.isEmpty()) { return true; }
        int head = 0;
        int tail = s.length()-1;

        while (head <= tail) {
            char headChar = Character.toLowerCase(s.charAt(head));
            char tailChar = Character.toLowerCase(s.charAt(tail));
            if (!Character.isLetterOrDigit(headChar)) {
                head ++;
            } else if (!Character.isLetterOrDigit(tailChar)) {
                tail --;
            } else {
                if (headChar != tailChar) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    /**
     * With 2 pointer approach
     * Time: O(N)
     * Space: O(N)
     * @param str String
     * @return boolean true if the string is palindrome
     */
    public static boolean palindromePermutation_iterate(String str) {
        if (str.length() == 1) {
            return true;
        }
        String str1 = str.replaceAll("\\s", "");
        String str2 = str.replaceAll("[^a-zA-Z0-9]+","").toLowerCase(); // if you want to replace all special characters;
        for (int i=0; i<str1.length()/2; i++) {
            if (str1.charAt(i) != str1.charAt(str1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
