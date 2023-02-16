package arraysAndStrings;

import java.util.Arrays;

/**
 * Fibonacci = 0 1 1 2 3 5 8 13 21 34
 * So fib(0) = 0, fib(1) = 1 => this is the base case
 * eg: fib(6) = 8
 */
public class Fibonacci {

    public static void main(String[] args){
        System.out.println("========Fib Number =============");
        System.out.println(5+" th fibonacci is "+ fibIteration(5));
        System.out.println(6+" th fibonacci is "+ fibIteration(6));
        System.out.println(8+" th fibonacci is "+ fibRecurse(8));

        System.out.println(5+" th fibonacci using formula is "+ fibFormula(5));
        System.out.println(6+" th fibonacci using formula is "+ fibFormula(6));
        System.out.println(8+" th fibonacci  using formula is "+ fibFormula(8));

        System.out.println("========Fib Series =============");
        System.out.println("10 fibSeries"  + Arrays.toString(generateFibNumbers(10)));
    }

    /**
     * In this program, the fibonacci method uses three integer variables: prev1, prev2, and fib.
     * It initializes prev1 and prev2 to 0 and 1, respectively, and then iteratively calculates the
     *  next Fibonacci number fib by adding prev1 and prev2.
     * After each iteration, it updates the values of prev1 and prev2 to the next pair of Fibonacci numbers.
     * Finally, it returns the value of fib, which is the nth Fibonacci number.
     * Using this optimized approach, we reduce the
     *  space complexity = O(1) and
     *  time complexity = O(n)
     * @param n
     * @return fibonacci numbers
     */
    public static int fibIteration(int n) {
        if (n <=1) return n;
        int prev1 = 0;
        int prev2 = 1;
        int fib = 0;
        for(int i=2; i<=n; i++){
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
        }
        return fib;
    }

    // Fn = [Phin – (phi)n] / Sqrt[5].
    // where Phi = (1 + Sqrt[5]) / 2 is the so-called golden mean
    public static int fibFormula(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn= Math.pow((1+sqrt5)/2,n) - Math.pow((1-sqrt5)/2,n);
        return (int)(fibn/sqrt5);
    }

    public static int[] generateFibNumbers(int n) {
        int[] fibSeries = new int[n+1];
        if (n==0) return fibSeries;
        fibSeries[1] = 1;
        if (n==1) {
            return fibSeries;
        }

        for (int i=2; i<=n; i++) {
            fibSeries[i] = fibSeries[i-1] + fibSeries[i-2];
        }
        return fibSeries;
    }
    /*
     ** Time Complexity: O(2^n)
     **  because the function makes two recursive calls in each step,
     *  which leads to an exponential increase in the number of function calls with each increase in the input size.
     *
     * Each recursive call to the function computes the nth Fibonacci number by computing the (n-1)th and (n-2)th Fibonacci numbers, respectively
     * This leads to a tree-like recursive call structure, where each node has two children.
     *  The number of nodes in this recursive call tree is 2^n, which is the number of recursive calls made by the function.
     *
     * Therefore, the time complexity of the recursive Fibonacci algorithm is O(2^n),
     *  as the number of function calls grows exponentially with the size of the input n.

     */
    public static int fibRecurse(int n){
        if(n==0 || n==1){
            return n;
        }
        else {
            return fibRecurse(n-1)+ fibRecurse(n-2);
        }
    }
}
