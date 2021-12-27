package arraysAndStrings;

import java.util.*;

public class CheckAnagram {

    public static void main(String[] args) {
        System.out.println("Expected: true: Actual: "  + isAnagram("manasa", "asanam"));
        System.out.println("Expected: true Actual: " + isAnagram("anagram", "nagaram"));
        System.out.println("Expected: false Actual: " + isAnagram("rat", "car"));
        System.out.println("Expected: true: Actual: " + isAnagram_array("manasa", "asanam"));
    }

    public static boolean isAnagramOof1(String s1, String s2) {
        if(s1.length() != s2.length()) {  return false; }
        int[] counter = new int[26]; // for 26 letters
        for (int i=0; i<s1.length(); i++) {
            counter[s1.charAt(i)-'a']++;
        }
        for (int j=0; j<s2.length(); j++) {
            counter[s2.charAt(j)-'a']--;
            if (counter[s2.charAt(j)-'a']<0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     * @param s string
     * @param t string
     * @return boolean indicating if strings are anagrams
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c)+1);
            } else {
                charCount.put(c, 1);
            }
        }
        for (char p: t.toCharArray()) {
            if (charCount.containsKey(p)) {
                charCount.put(p, charCount.get(p)-1);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry: charCount.entrySet()) {
            if (entry.getValue() !=0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_array (String str1, String str2) {
        if (str1.length() != str2.length()) { return false; }
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

}