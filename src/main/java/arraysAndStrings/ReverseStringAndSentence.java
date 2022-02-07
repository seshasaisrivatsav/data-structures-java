package arraysAndStrings;

/**
 * Reverse String and Sentence
 * String = abcd => Reversed = dcba
 * Sentence = a boy met a girl => Reversed girl a met boy a
 */
public class ReverseStringAndSentence {
    
    public static void main(String[] args){
        // String reversal
        System.out.println(reverseString_stringBuilder_removeSpace("abcdefg"));
        System.out.println(reverseString_stringBuilder_removeSpace("abra   ca"));
        System.out.println(reverseString_charArray("in place string reversal"));

        // Sentence reversal
        System.out.println(reverseSentence_stringBuilder("this is a nice     string"));
        System.out.println(reverseSentenceInPlace("a boy met a girl"));;
    }

    /**
     * Reverse a string by remove space
     * Time Complexity: O(N)
     * Space Complexity: O(1) - if result space is not considered used
     *  Approach: Use String builder
     *            Iterate from reverse and append to answer if character is not equal to ' '
     * @param str String
     * @return String reversed
     */
    public static String reverseString_stringBuilder_removeSpace(String str) {
        StringBuilder answer= new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            if (str.charAt(i) != ' ') {
                answer.append(str.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1) - if result space is not considered used
     * @param string String
     * @return String reversed
     */
    public static String reverseString_charArray(String string) {
        char[] stringChars = string.toCharArray();
        int start = 0;
        int end = stringChars.length-1;
        while (start <= end) {
            char temp = stringChars[start];
            stringChars[start] = stringChars[end];
            stringChars[end] = temp;
            start ++;
            end --;
        }
        return new String(stringChars);
    }

    /**
     * Approach:
     *      - Reverse the entire string sentence in place from 0 to length
     *      - iterate through the string and keep a variable 'start' to indicate when to reverse
     *           Given: this is new
     *           Expected: new is this
     *             step 1: wen si sith
     *             step 2: new is this
     * Time: O(n)
     * Space: O(n)
     * @param str String
     * @return String reversed
     */
    public static String reverseSentenceInPlace(String str) {
        char[] givenString = str.toCharArray();
        reverseWordInPlaceHelper(givenString, 0, givenString.length-1);
        int start = 0;
        for(int i=0; i<givenString.length; i++) {
            if (givenString[i] == ' ') {
                reverseWordInPlaceHelper(givenString, start, i-1);
                start = i+1;
            }
        }
        // for the last iteration
        reverseWordInPlaceHelper(givenString, start, givenString.length-1);
        return String.valueOf(givenString);
    }

    public static void reverseWordInPlaceHelper(char[] chars, int start, int end) {
        while(start<=end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }


    public static String reverseSentence_stringBuilder(String str) {
        StringBuilder result = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            if (str.charAt(i) == ' ') {
                result.append(str.substring(i + 1)).append(" ");
                str = str.substring(0,i);
            }
        }
        // After the final loop the first word will be left over
        return result.append(str).toString();
    }


    /**
     * Reverse sentence and remove extra chars
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        if (str.length()==0 || str.length() ==1) {return str;}
        char[] chars = str.toCharArray();
        reverseCharString(chars, 0, chars.length-1);
        int i = 0; int j=0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                reverseCharString(chars, j, i-1);
                j = i+1;
            }
            i++;
        }

        // for the last iterative
        reverseCharString(chars, j, chars.length-1);
        return String.valueOf(chars).replaceAll("\\s+", " " );
    }
    private static void reverseCharString(char[] chars, int start, int end) {
        while (start <= end) {
            char curr = chars[start];
            chars[start] = chars[end];
            chars[end] = curr;
            start ++;
            end --;
        }
    }
}
