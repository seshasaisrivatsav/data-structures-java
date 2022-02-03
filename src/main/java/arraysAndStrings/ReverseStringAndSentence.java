package arraysAndStrings;

/**
 * Reverse String and Sentence
 * String = abcd => Reversed = dcba
 * Sentence = a boy met a girl => Reversed girl a met boy a
 */
public class ReverseStringAndSentence {
    
    public static void main(String[] args){
        // String reversal
        System.out.println(reverseString_stringBuilder_removeSpace("abra   ca"));
        System.out.println(reverseString_inPlace("in place string reversal"));

        // Sentence reversal
        System.out.println(reverseSentence_stringBuilder("this is a nice     string"));
        System.out.println(reverseSentenceInPlace("a boy met a girl"));;
    }

    /**
     * Reverse a string by remove space
     * Time Complexity: O(N)
     * Space Complexity: O(N) - result space used
     *  Approach: Use String builder
     *            Iterate from reverse and append to answer if character is not eyual to ' '
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
     * Space Complexity: O(1) - if result isn't added
     * @param string String
     * @return String reversed
     */
    public static String reverseString_inPlace(String string) {
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

    /*
            given: this is new
            expected: new is this

            step 1:
            wen si sith

            step 2:
            new is this
     */



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
    
}
