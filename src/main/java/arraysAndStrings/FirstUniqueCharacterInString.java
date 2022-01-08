package arraysAndStrings;

import java.util.HashMap;

/*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
    https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println("Expected: 0 Actual: " + firstUniqueCharacterHashMap("leetcode"));
        System.out.println("Expected: 2 Actual: " + firstUniqueCharacterHashMap("loveleetcode"));
        System.out.println("Expected: -1 Actual: " + firstUniqueCharacterHashMap("aabb"));

        System.out.println("Expected: 0 Actual: " + firstUniqueStringArray("manasa"));
        System.out.println("Expected: 4 Actual: " + firstUniqueStringArray("allapc"));
        System.out.println("Expected: -1 Actual: " + firstUniqueStringArray("aabb"));
    }

    /**
     * Approach: Create a hash map that maintains character and character counts
     *          Iterate through the string and if a char in string in hash map has value of 1, return that index
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1) => Since english = 26
     * @param s String
     * @return int
     */
    public static int firstUniqueCharacterHashMap(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c)+1);
            } else {
                charCount.put(c, 1);
            }
        }
        for (int i=0; i<s.length(); i++) {
            if (charCount.get(s.charAt(i)) ==1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach: Create an array for characters of length 26 and insert at position charAt(i)-'a'
     *          iterate string and if char array has length 1, return that
     * @param str String
     * @return int
     */
    public static int firstUniqueStringArray(String str) {
        if(str.length()==0) {return -1;}
        if(str.length()==1) {return 0;}
        int[] chars = new int[26];
        for (int i=0; i<str.length(); i++) {
            chars[str.charAt(i)-'a']++;
        }
        for (int i=0; i<str.length(); i++) {
            if (chars[str.charAt(i)-'a'] == 1) { return i;}
        }
        return -1;
    }
}
