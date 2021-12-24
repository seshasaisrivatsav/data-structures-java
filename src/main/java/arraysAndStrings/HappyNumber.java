package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/*
    A good way to get started with a question like this is to make a couple of examples. Let's start with the number 77. The next number will be 49 (as 7^2 = 49)
    and then the next after that will be 97 (as 4^2 + 9^2 = 97 as 4^2+9^2 =97).
     We can continually repeat the process of squaring and then adding the digits until we get to 1.
      Because we got to 1, we know that 7 is a happy number, and the function should return true.

    As another example, let's start with 116.
    By repeatedly applying the squaring and adding process, we eventually get to 58, and then a bit after that, we get back to 58.
    Because we are back at a number we've already seen, we know there is a cycle, and therefore it is impossible to ever reach 11. So for 116, the function should return false.

Based on our exploration so far, we'd expect continually following links to end in one of three ways.
    It eventually gets to 11.
    It eventually gets stuck in a cycle.
    It keeps going higher and higher, up towards infinity.
    That 3rd option sounds really annoying to detect and handle. How would we even know that it is going to continue going up, rather than eventually going back down, possibly to 1?
    Luckily, it turns out we don't need to worry about it. Think carefully about what the largest next number we could get for each number of digits is.
    Digits	Largest	Next
        1	9	             81
        2	99	            162
        3	999	            243
        4	9999	        324
        13	9999999999999	1053


 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("expected: true actual: " + isHappy(19));
        System.out.println("expected: true actual: " + isHappy(7));
        System.out.println("expected: false actual: " + isHappy(116));

        System.out.println("expected: true actual: " + isHappy_myWay(19));
        System.out.println("expected: true actual: " + isHappy_myWay(7));
        System.out.println("expected: false actual: " + isHappy_myWay(116));
    }

    /**
     * Time Complexity: O(log n)
     *  - Explanation: how many times getNext is called
     *
     * @param n
     * @return
     */
    public static boolean isHappy_myWay(int n) {
        if (n==1) { return true; }
        Set<Integer> seenNumbers = new HashSet<>();
        while (n!=1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getSumOfSquares(n);
        }
        return (n == 1);
    }

    public static boolean isHappy(int n) {
        while(n != 1 && n!=4) {
            n = getSumOfSquares(n);
        }
        return n==1;
    }
    public static int getSumOfSquares(int n) {
        int res = 0;
        while (n > 0) {
            int remainder = n % 10;
            res = res + (remainder*remainder);
            n = n/10;
        }
        return res;
    }
}
