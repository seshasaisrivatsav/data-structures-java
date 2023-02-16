package arraysAndStrings;

/**
 * There are 3 types of edits
 *  1. Insert
 *  2. Remove
 *  3. Replace
 *  Write a function to check they're one or zero edits away
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneAway("aa", "aabb"));
    }

    /**
     * Approach:
     *  We return false if the string length difference exceeds one.
     *  And if the string lengths match, we loop through strings and return false when we encounter a different char if we already found one
     *
     *  If the string lengths differ by 1, we take the smaller and larger string, as its quick to exit sooner if we already encounter a variation in shorter string
     *
     *      NOTE: CTCI has abstracter for case 3 and case 4
     * Space Complexity: O(1)
     * Time Complexity: O(N)
     * @param str1 String
     * @param str2 String
     * @return true if it's one edit away
     *
     */
    public static boolean oneAway(String str1, String str2) {
        if (str1.equals(str2)) return true; // CASE 1: Return true if both are same
        if (Math.abs(str1.length()-str2.length()) > 1) return false; // CASE 2: Return false if length difference is > 1

        // CASE 3: When they're of same length, keep a counter for difference
        if (str1.length() == str2.length()) {
            boolean foundDifference = false;
            for (int i = 0; i < str1.length(); i++) {
                // if the characters don't match, foundDifference = true for first time and subsequent time return false
                if (str1.charAt(i) != str2.charAt(i)) {
                    if (foundDifference) {
                        return false;
                    }
                    foundDifference = true;
                }
            }
        }

        // CASE 4: when they're of 1 diff
        int ptr1=0, ptr2=0;
        String shortString = str1.length() < str2.length() ? str1 : str2;
        String longString = str1.length() > str2.length() ? str1 : str2;
        boolean foundReplacement = false;
        while(ptr1 < shortString.length() && ptr2 < longString.length()) {
            if (shortString.charAt(ptr1) != longString.charAt(ptr2)) {
                if (foundReplacement) {
                    return false;
                }
                foundReplacement = true;
                ptr2 ++;
            } else {
                ptr1++;
                ptr2++;
            }

        }
        return true;
    }

}
