package arraysAndStrings;

/**
 *  String compression to count repeated characters. If the resultant string is bigger than original string, return original string
 *  Eg: aabcccccaaa => a2b1c5a3
 * --
 *  StringBuilder V/S String
 *  In Java, both String and StringBuilder are used to handle strings, but they have some key differences.
 * String is an immutable class, meaning that once a String object is created, its value cannot be changed.
 * Any operation that appears to modify a String object actually creates a new String object with the new value.
 * This can have performance implications when working with large strings, as each time a modification is made, a new String object must be created.
 * On the other hand, StringBuilder is a mutable class, meaning that its value can be changed after it is created.
 * It provides a more efficient way of building strings, as it only needs to allocate memory once and then can append or insert values directly into the existing buffer.
 * This can lead to much better performance when working with large strings, as only a single object needs to be created and modified.
 * In general, it is recommended to use StringBuilder when you need to build strings, and to use String when you have a string that will not change.
 * However, it's important to keep in mind that StringBuilder is not thread-safe, meaning that if you need to access the same StringBuilder from multiple threads, you will need to add synchronization to ensure that the operations are thread-safe.
 * In summary, the main difference between String and StringBuilder is that String is immutable and StringBuilder is mutable.
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
     * V.V.I.P: Using StringBuilder for concatenation is better than using string
     *      As for string concat a new string copy is used and thus takes O(n2)
     *      With String Builder, simply creates resizable array and thus takes O(n)
     * @param str String
     * @return Compressed string
     */
    public static String compressString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
        for (int i=0; i<str.length(); i++) {
            // If the characters next to one another aren't matching, append counter, reset counter to 1
            // or if the next character is the last character, append the result
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
