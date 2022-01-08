package general;

import java.util.HashMap;
import java.util.Map;

public class DeleteMe {
    public static void main(String[] args) {
        // Index of test
        String str = "abbcdef";
        System.out.println("index of a in "+ str + " " + str.indexOf("a"));
        System.out.println("index of z in "+ str + " " + str.indexOf("z"));
        System.out.println("index of char b in "+ str + " " + str.indexOf('b'));

        System.out.println(firstUniqueCharacter("leetcode"));

    }


    public static int firstUniqueCharacter(String s) {
        if (s.length()==0) {return -1;}
        if (s.length()==1) {return 0;}
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c: s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character,Integer> entry: hm.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
