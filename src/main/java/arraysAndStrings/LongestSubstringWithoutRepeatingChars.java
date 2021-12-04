package arraysAndStrings;

/**
 * Return the length of longest substring without repeating characters
 * abcdabcgab = abcd, bcda, cda, bcgab = 5
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_bruteForce("abcabcbb"));
        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_slidingWindow_n2("abcabcbb"));
        System.out.println("Expected 9. Actual :" + getLongestSubstringLength_slidingWindow_n2("abcdeefghijabc"));



        System.out.println("Expected 3. Actual :" + getLongestSubstringLength_slidingWindow_n("abcabcbb"));
        System.out.println("Expected 9. Actual :" + getLongestSubstringLength_slidingWindow_n("abcdeefghijabc"));

    }

    /**
     * Approach 1: Using window sliding, the problem can be solved in linear time
     * Whenever we see a repetition, we move the window till the repeated string
     * @param str
     * @return
     */
    public static int getLongestSubstringLength_slidingWindow_n(String str) {
        if (str.isEmpty()) { return 0; }
        if (str.length()==1) { return 1; }

        String temp = "";
        int maxLength = -1;

        /*
            abcabcbb temp  = "", ml=-1
            temp = a, ml = 1
            temp = ab ml = 2
            temp = abc ml = 3
            temp = bc
                   bca ml = 3
         */
        for (char c: str.toCharArray()) {
            String curr = String.valueOf(c);

            if (temp.contains(curr)) {
                temp = temp.substring(temp.indexOf(curr) + 1); // sliding
            }
            temp = temp + curr;
            maxLength = Math.max(temp.length(), maxLength);
        }
        return maxLength;
    }


    /**
     * Window sliding with
     *  Time Complexity: O(n^2)
     * @param str
     * @return
     */
    public static int getLongestSubstringLength_slidingWindow_n2(String str) {
        if (str.isEmpty()) return 0;
        int res = 0;
        for (int i=0; i<str.length(); i++) {
            boolean[] visited = new boolean[256];
            for (int j=i; j<str.length(); j++) {
                if (visited[str.charAt(j)]) { // If we already found it, break the current loop and mark this character as false for next iteration
                    break;
                } else {
                    visited[str.charAt(j)] = true;
                    res = Math.max(res, j-i+1);
                }
            }
            visited[str.charAt(i)]=false; // since the window moved, mark the previous one as false
        }
        return res;
    }
    /**
     * Time complexity: O(n^3) - two for loops - n2 + search in string n = n^3
     * @param str
     * @return
     */
    public static int getLongestSubstringLength_bruteForce(String str) {
        String res = "";
        int max = Integer.MIN_VALUE;
        for(int i=0; i<str.length(); i++) {
            res = "";
            for(int j=i; j<str.length(); j++) {
                if (res.contains(String.valueOf(str.charAt(j)))) {
                    break; // breaks the loop
                }
                res = res + str.charAt(j);
                max = Math.max(res.length(), max);
            }
        }
        return max;
    }

}
