package dynamicProgramming;

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
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Expected: 3 Actual: " + climbStairs(3));
        System.out.println("Expected: 8 Actual: " + climbStairs(5));
        System.out.println("Expected: 13 Actual: " + climbStairs(6));
    }

    /**
     * Dynamic Programming:
     *  One can reach ith step in two ways
     *      1. taking a single step from (i-1)th step
     *      2. taking a step of two from (i-2)th step
     *  Total number of ways to reach ith step = #ways of reaching (i-1)th step   +   #ways of reaching (i-2)th step
     *  dp[i] = dp[i-1] + dp[i-2]
     *
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * @param top int
     * @return int
     */
    public static int climbStairs(int top) {
        if (top == 1 || top== 2) {
            return top;
        }
        int[] dp = new int[top+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3; i<=top; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[top];
    }
}
