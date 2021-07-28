package arraysAndStrings;

import java.util.Arrays;

/**
 *
 */
public class URLify {
    public static void main(String[] args) {
        String str = "pan cakes  ";
        char[] chars = str.toCharArray();
        System.out.println(urlify(chars, 9));
    }


    /**
     * Given a character array representing a sentence with extra spaces at the end to account for %20
     * Write a method to replace the spaces with `%20`
     *
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     *
     * Approach 1: Do this in-place
     *          We first count number of spaces.
     *          By tripling it we get the spaces required for %20
     *          In the second pass, in reverse order, we edit the string as we replace it with %20, by using 2 pointers
     *              pointer 1: will be at the end of actual text
     *                          if the first pointer finds a space, we will make %20 string as position of second pointer
     *                          decrements by 3
     *              pointer 2: will be at end of the string
     *                          decrements by 1
     *
     *
     * Assumption: We have extra space in input
     * @param str character array
     * @param trueLength string length with extra spaces
     * @return String with spaces replaced with %20
     *
     * Example:
     *  Input: "pan cakes  ", 9  (here, the string has 2 extra spaces. chars.length = 11, 9 is the )
     *
     * For above example
     * p a n   c a k e s
     * - - - - - - - - - - -
     *  True length = 9
     *  Space count = 1
     *  final index = 9 + (1 * 2) = 11
     *
     *  So start iterating from (9-1)st position
     *      i => index with space
     *      trueLength => char
     */
    public static String urlify(char[] str, int trueLength) {
        // STEP 1: Count the space
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i ++) { // Note that we iterate only till end of character, not string
            if (str[i] == ' ') {
                spaceCount ++;
            }
        }

        // Second counter
        int finalIndex = trueLength + (spaceCount * 2);

        // Iterate from reverse (and start from trueLength - 1 as final index goes to + 1)
        for (int stringIndex = trueLength - 1; stringIndex >= 0; stringIndex--) {
            if (str[stringIndex] == ' ') { // if we encounter a space
                str[finalIndex - 1] = '0';
                str[finalIndex - 2] = '2';
                str[finalIndex - 3] = '%';
                finalIndex = finalIndex - 3; // decrement by 3
            } else {
                str[finalIndex - 1] = str[stringIndex];
                finalIndex --; // decrement by 1
            }
        }
        return new String(str);
    }

    /**
     * PS: Ignore the below
     * Given a string, the method will need to replace the spaces with `%20`
     * @param str String
     * @return string
     */
    public static String urlify_string(String str) {
        StringBuilder res = new StringBuilder();
        for(char c: str.toCharArray()) {
            // NOTE: you can't do character = character. You need to .equals
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
