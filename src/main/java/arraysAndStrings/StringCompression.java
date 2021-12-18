package arraysAndStrings;

/**
 *  String compression to count repeated characters. If the resultant string is bigger than original string, return original string
 *  Eg: aabcccccaaa => a2b1c5a3
 *
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString2("aabcccccaaa"));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * VVIP: Using StringBuilder for concatenation is better than using string
     *      As for string concat a new string copy is used and thus takes O(n2)
     *      With String Builder, simply creates resizable array and thus takes O(n)
     * @param str
     * @return
     */
    public static String compressString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
        for (int i=0; i<str.length(); i++) {
            // If the characters next to one another aren't matching, append counter, reset counter to 1
            // handle edge case of last character
            if ((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                stringBuilder.append(str.charAt(i)).append(counter);
                counter = 1;
            } else {
                counter++;
            }
        }
        if (stringBuilder.length() > str.length()) {
            return str;
        }
        return stringBuilder.toString();
    }


    public static String compressString2(String str) {
        StringBuilder res = new StringBuilder();
        int ptr = 0;
        int counter = 1;
        while (ptr < str.length()) {
            if (ptr+1 >= str.length() || str.charAt(ptr) != str.charAt(ptr+1)) {
                res.append(str.charAt(ptr)).append(counter);
                counter = 1;
            } else {
                counter ++;
            }
            ptr++;
        }
        return res.toString();
    }
}
