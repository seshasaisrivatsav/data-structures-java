package arraysAndStrings;


/**
 * Source: Cracking the Coding Interview (C.T.C.I)
 * Implement an algorithm to determine if a string is unique without using any datastructures
 * Assumption:
 *  = string contains characters from `a` to `z`
 *  = integers are stored using 32 bits
 * <a href="https://www.geeksforgeeks.org/efficiently-check-string-duplicates-without-using-additional-data-structure/">...</a>
 * Notes
 *  = ASCII characters are 8 bits
 *  = UNICODE characters are 16 bits
 **/
public class IsUniqueString {
    
    public static void main(String[] args){
        // With O(1) space O(n) time
        System.out.println("Expected: false. Actual: " + isUnique("zxz"));
        System.out.println("Expected: false. Actual: " + isUnique("defgd"));
        System.out.println("Expected: false. Actual: " + isUnique("zfgadzd"));
        System.out.println("Expected: true. Actual: " + isUnique("abcdefgh"));

        // With O(n) space O(n) time
        System.out.println("Expected: false. Actual: " + isUniqueAdditionalDataStructure("abcd1a"));
        System.out.println("Expected: true. Actual: " + isUniqueAdditionalDataStructure("abcdef"));
    }

    /**
     * Approach 1:
     *  Here, instead of creating a boolean array, we use int to represent series of bits where each position initially false
     *      and return false if we already find a true somewhere
     *
     *      Left Shift Example:
     *             5 in binary is 101
     *             5 << 1 => 1010
     *             5 << 2 => 10100
     *             5 << 3 => 101000
     *
     *      1 << diff ===> creates an int value that has all bits zero except for the val-th bit
     *      We then use bitwise AND to AND this value with `checker`
     *      if the result of checker AND 1 << val is greater than 0 it means the value is found, so return false
     *
     * Setting the value for the first time:
     *    if not, then we do checker |= (1 << val). This is equivalent to checker = checker | ( 1 << val)
     *    Where | is the OR operator.
     *
     *  Space Complexity: O(1)
     *  Time Complexity: O(n)
     *
     *  notes: https://mkyong.com/java/java-and-bitwise-shift-operator/
     * @param str string to check
     * @return true if the string is unique
     */
    public static boolean isUnique(String str) {
        // Since there are 256 characters in ascii
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (char c: str.toCharArray()) {
            int val = c - 'a';
            /*
            System.out.println("val: " + Integer.toBinaryString(val));
            System.out.println("checker: " + Integer.toBinaryString(checker));
            System.out.println("1<<val: " + Integer.toBinaryString(1<<val));
            */
            if ((checker & (1 << val)) > 0) { // if a bit is found, it means we've previously seen the value
                return false;
            }
            checker |= (1 << val); // change checker to also have the diff checker = checker | (1<<str.charAt(i)-'a')
        }
        return true;
    }

    /**
     * Approach 2:
     *  - This approach uses an additional data structure
     *
     * There are 128 total characters but total number of characters in ASCII table is 256
     *  - 0 to 31 - ASCII Control characters
     *  - 32 - 127 - ASCII printable characters
     *  - 128 - 255 - Extended ASCII codes
     *
     *  Important - string.charAt gives the ASCII code
     * @param str String
     * @return boolean true if the given string is unique
     */
    public static boolean isUniqueAdditionalDataStructure(String str) {
        if (str.length() > 256){
            return false;
        }

        // We create a boolean array where each element represents the presence of an ascii character
        boolean[] char_set = new boolean[256];

        // We iterate through string and return false if an element's value at the ASCII position is true
        // and set the value to true if not present
        // If the whole loop is complete, we return false to indicate that the string is unique
        for (int i=0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    
}

