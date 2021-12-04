package arraysAndStrings;

public class ReverseStringAndSentence {
    
    public static void main(String[] args){
        String str = "abra   ca ";
        System.out.println(reverseString(str));

        String s = "this is a nice     string";
        System.out.println(reverseSentence(s));

        System.out.println("++++");
        System.out.println(reverseSentenceInplace("this is good"));;
    }
     
    public static String reverseString(String str) {
        StringBuilder answer= new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            if (str.charAt(i) != ' ') {
                answer.append(str.charAt(i));
            }
        }
        return answer.toString();
    }

    /*
            given: this is new
            expected: new is this

            step 1:
            wen si sith

            step 2:
            new is this
     */

    public static void reverseInPlace(char[] chars, int start, int end) {
        while(start<=end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param str
     * @return
     */
    public static String reverseSentenceInplace(String str) {
        char[] givenString = str.toCharArray();
        reverseInPlace(givenString, 0, givenString.length-1);
        int start = 0;
        for(int i=0; i<givenString.length; i++) {
            if (givenString[i] == ' ') {
                reverseInPlace(givenString, start, i-1);
                start = i+1;
            }
        }
        reverseInPlace(givenString, start, givenString.length-1);
        return String.valueOf(givenString);
    }
    public static String reverseSentence(String str) {
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
