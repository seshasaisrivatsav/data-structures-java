package arraysAndStrings;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *  n = 5 => 8 ways to climb till top
 *          1 1 1 1 1
 *          1 1 1 2
 *          1 1 2 1
 *          1 2 1 1
 *          2 1 1 1
 *          1 2 2
 *          2 1 2
 *          2 2 1
 * n = 3 => 3 ways to climb till top
 *          1 1 1
 *          1 2
 *          2 1
 */
public class ClimbingStairsFibonacci {
    public static void main(String[] args) {
        System.out.println("Expected: 3 Actual: " + climbStairsFibonacciFormula(5));
        System.out.println("Expected: 13 Actual: " + climbStairsFibonacciFormula(6));
        System.out.println("Expected: 3 Actual: " + climbStairsFibonacciFormula(3));
        System.out.println("Expected: 8 Actual: " + climbStairsWithFibonacciBruteForce(5));
        System.out.println("Expected: 13 Actual: " + climbStairsWithFibonacciBruteForce(6));
    }

    // For

    /*
     Binet's method to calculate fibonacci
         Q  =       Fn+1 Fn      1  1  ^ n
                    Fn   Fn-1    1  0

                    Q = F * I^n
         As per formula, nth fibonacci number = Q^(n-1) [0, 0]

         Q2 =
     */
    public static int climbStairsFibonacciFormula(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
    /**
     * Time Complexity = O(n)
     * S[
     * The problem is done using DP in ClimbingStairs.java
     * That is same as fibonacci
     * We need to find nth fibonacci number
     * @param top
     * @return
     */
    public static int climbStairsWithFibonacciBruteForce(int top) {
        if (top == 1 || top== 2) {
            return top;
        }
        int fibA = 1;
        int fibB = 2;
        for (int i=3; i<=top; i++) {
            int fibC = fibA + fibB;
            fibA = fibB;
            fibB = fibC;
        }
        return fibB;
    }
}
