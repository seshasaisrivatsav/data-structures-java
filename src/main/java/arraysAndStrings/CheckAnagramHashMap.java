package arraysAndStrings;

import java.util.*;

public class CheckAnagramHashMap {

    public static void main(String[] args) {
        System.out.println(isAnagram("manasa", "asanam"));
    }

    /**
     * @param str1 string
     * @param str2 string
     * @return boolean indicating if strings are anagrams
     */
    public static boolean isAnagram(String str1, String str2) {
        int s = 0;
        HashMap<Character, Integer> str1HashMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1HashMap.containsKey(str1.charAt(i))) {
                str1HashMap.put(str1.charAt(i), str1HashMap.get(str1.charAt(i)) + 1);
            } else {
                str1HashMap.put(str1.charAt(i), 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (str1HashMap.containsKey(str2.charAt(i))) {
                if (str1HashMap.get(str2.charAt(i)) < 0) {
                    return false;
                } else {
                    str1HashMap.put(str2.charAt(i), str1HashMap.get(str1.charAt(i)) - 1);
                }
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            s = s + str1HashMap.get(str1.charAt(i));
            if (s > 0) return false;
        }

        return true;
    }

}