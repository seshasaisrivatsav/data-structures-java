package arraysAndStrings;

import java.util.HashMap;

/*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println("Expected: 0 Actual: " + firstUniqueCharacterHashMap("leetcode"));
        System.out.println("Expected: 2 Actual: " + firstUniqueCharacterHashMap("loveleetcode"));
        System.out.println("Expected: -1 Actual: " + firstUniqueCharacterHashMap("aabb"));
    }

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
}
