package arraysAndStrings;


/**
 * Source: Cracking the Coding Interview (CTCI)
 * Implement an algorithm to determine if a string is unique without using any datastructures
 * Assumption:
 *  = string contains characters from `a` to `z`
 *  = integers are stored using 32 bits
 * https://www.geeksforgeeks.org/efficiently-check-string-duplicates-without-using-additional-data-structure/
 *
 * Notes
 *  = ASCII characters are 8 bits
 *  = UNICODE characters are 16 bits
 **/
public class IsUniqueString {
    
    public static void main(String[] args){
        String str = "abcd1a";

        // Approach 1
        System.out.println(1 << 5);
        System.out.println(isUnique("csd"));

        // Approach 2
        if (IsUniqueString.isUniqueAdditionalDataStructure(str)) {
            System.out.println("is unique");
        } else {
            System.out.println("is not unique");
        }
    }

    /**
     * Approach 1:
     *  Here, instead of creating a boolean array, we use int to represent series of buts where each position initially false
     *      and return false if we already find a true somewhere
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
     * @param str string to check
     * @return true if the string is unique
     */
    public static boolean isUnique(String str) {
        // Since there are 256 characters in ascii
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
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
     * @param str
     * @return
     */
    public static boolean isUniqueAdditionalDataStructure(String str){
        if (str.length() > 256){
            return false;
        }

        // We create a boolean array where each element represents the presence of an ascii character
        boolean[] char_set = new boolean[256];

        // We iterate through string and return false if an element's value at the ASCII position is true
        // and set the value to true if not present
        // If the whole loop is complete, we return false to indicate that the string is unique
        for (int i=0; i < str.length(); i++){
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            }
        char_set[val] = true;
        }
        return true;
        
    }
    
}

