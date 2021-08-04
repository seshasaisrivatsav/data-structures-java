package arraysAndStrings;

public class ReverseStringAndSentence {
    
    public static void main(String[] args){
        String str = "abra   ca ";
        System.out.println(reverseString(str));

        String s = "this is a nice string";
        System.out.println(reverseSentence(s));
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
