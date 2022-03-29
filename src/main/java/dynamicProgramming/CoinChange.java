package dynamicProgramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 *  a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 *
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *      Input: coins = [1,2,5], amount = 11
 *      Output: 3
 *      Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *      Input: coins = [2], amount = 3
 *      Output: -1
 *
 * Example 3:
 *      Input: coins = [1], amount = 0
 *      Output: 0
 *
 * Example 4:
 *      Input: coins = [2,3,5,7], amount = 11
 *      Output: 3
 *
 * Example 5:
 * coins = {2,3,7}      amount = 15:     use 4 coins, e.g., [2,3,3,7]
 *
 * Solution:
 * https://youtu.be/jgiZlGzXMBw
 * https://trykv.medium.com/how-to-solve-minimum-coin-change-f96a758ccade
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println("Expected: 3 Actual" + getMinCoins_bottomUp(11, new int[]{1,2,5 }));
        System.out.println("Expected: 10 Actual" + getMinCoins_bottomUp(90, new int[]{1, 3, 5, 6, 9}));
        System.out.println("Expected: -1 Actual" + getMinCoins_bottomUp(5, new int[]{2 }));
    }
    /**
     * In this approach we build solutions with previous knowledge
     *
     * Steps
     *  - Initialize an array dp of size sum+1, where dp[i] represents minimum coins needed to make i
     *  - Base case: dp[0] = minimum number of coins to make 0 = 0
     *  - Initialization: dp[i] where i=1 to i=sum+1 is + INFINITY (as we look for min, initialize with max)
     *
     *  Bottom approach
     *
     *
     * Time Complexity:
     *      Amt = A = given sum / amount
     *      Total Coins  = C1 + C2.. Cn = C
     *
     *      Time = O(A*C)
     *
     * Space Complexity:
     *      O(A)
     * @param amt int given sum
     * @param coins int[] given coins
     * @return int minimum coins needed
     */
    public static int getMinCoins_bottomUp(int amt, int[] coins) {
        int[] dp = new int[amt+1];

        Arrays.fill(dp, amt+1);

        dp[0] = 0; // base case

        // The outer for loop computers minimum coins needed for respective amt
        for (int i=1; i<=amt; i++) {
            // Inner for loop looks at coins
            for (int coin : coins) {
                if (i-coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amt] > amt ? -1 : dp[amt];
    }
}
