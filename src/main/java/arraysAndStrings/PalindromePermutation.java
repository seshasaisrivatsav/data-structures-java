package arraysAndStrings;

/**
 * Given a string write a function to check if it's a permutation of a palindrome
 *
 * Palindrome = word/phrase that is same forwards and backwards
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(palindromePermutation_iterate("aa"));
        System.out.println(palindromePermutation_iterate("abb"));
        System.out.println(checkPalindrome_string_ignoreSpecialCharsOof1("A man, a plan, a canal: Panama"));

    }

    // isLetterOrDigit
    public static boolean checkPalindrome_string_ignoreSpecialCharsOof1(String s) {
        if (s.isEmpty()) { return true; }
        int head = 0;
        int tail = s.length()-1;

        while (head <= tail) {
            char headChar = s.charAt(head);
            char tailChhar = s.charAt(tail);
            if (!Character.isLetterOrDigit(headChar)) {
                head ++;
            } else if (!Character.isLetterOrDigit(tailChhar)) {
                tail --;
            } else {
                if (Character.toLowerCase(headChar) != Character.toLowerCase(tailChhar)) {
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
     * @param str
     * @return
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
