package arraysAndStrings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/string-compression/
 *
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 *
 * Example 1:
 *     Input: chars = ['a','a','b','b','c','c','c']
 *     Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
 *     Explanation: The groups are 'aa', 'bb', and 'ccc'. This compresses to 'a2b2c3'.
 *
 * Example 2:
 *     Input: chars = ['a']
 *     Output: Return 1, and the first character of the input array should be: ['a']
 *     Explanation: The only group is 'a', which remains uncompressed since it's a single character.
 *
 * Example 3:
 *     Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 *     Output: Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
 *     Explanation: The groups are 'a' and 'bbbbbbbbbbbb'. This compresses to 'ab12'.
 */
public class StringCompressionArray {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compressChars(chars));
        System.out.println("Expected: [a, b, 1, 2 ...] Actual: " + Arrays.toString(chars));

        char[] chars1 = {'a','a','b','b','b','c','c','c'};
        System.out.println(compressChars(chars1));
        System.out.println("Expected: [a, 2, b, 3, c, 3 ...] Actual:" + Arrays.toString(chars1));
    }

    /**
     * Approach: Have two pointers i and j, both initially at zero
     *           Iterate over chars, as long as i less than chars.length
     *                  increment i as long as we run into a different character, and increment count
     *                  using j to keep the character, j+1th place to compute the count
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * Run down:
     *          a a a b b c c
     *          i
     *          j
     *          a a a b b c c
     *                i
     *            j
     *          a 3 b 3 c 3 c
     *                        i
     *                      j
     *
     *          a a ..a a a (13x) b b b  c
     *                            i
     *            j
     *          a 1 3..a a a (13x) b b b  c
     *                            i
     *                j
     * @param chars char[]
     * @return int representing the new length of compressed
     */
    public static int compressChars(char[] chars) {
        int i=0; // pointer that counts => fast
        int j=0; // the pointer that saves char and count => slow
        while (i < chars.length) {
            char currChar = chars[i];
            int count=0;
            // iterate until you find a different character
            // a  b c
            //    ij
            while (i < chars.length && chars[i]==currChar) {
                i++;
                count++;
            }
            // value at pointer j will be having previous character (i-1)
            // and increment j, this is where we keep the count of chars
            chars[j] = chars[i-1];
            j++;

            // Only update count if it's > 1
            if (count > 1) {
               for (char ct: String.valueOf(count).toCharArray()) {
                   chars[j] = ct;
                   j++;
               }
            }
        }
        return j;
    }

    /**
     * Time complexity: O(N) - we walk through string once, n = no of chars
     * Space Complexity: O(1)
     * @param chars char
     * @return index or leng
     */
    public static int compressString(char[] chars) {
        if (chars.length==0) {return 0;}
        if (chars.length==1) {return 1;}
        int k = 0; // keeps track of where to place the number;
        int i = 0; // pointer 1 to walk through entire string

        while (i < chars.length) {
            int j = i; // pointer 2 j, initially points to j, j walks forward while smae chars
            // move while characters are same
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            // place the character at i and move k forward
            chars[k] = chars[i];
            k++;

            // if we saw the character more than once, then we need to compress
            if (j-i>1) {
                /*
                we run into this case when consecutive letters are same
                eg:
                    a a b
                    i   j   here j-1 = 2-0 = 2

                 */
                String count = j-i + "";
                for (char ct: count.toCharArray()) {
                    chars[k] = ct;
                    k++;
                }
            }
            // move i to j
            i = j;
        }
        return i; // new length of compressed array
    }


}
