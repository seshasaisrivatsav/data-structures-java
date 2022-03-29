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
     * In this approach we build solutions with previous knowledge = Bottom up
     *
     * - We store the results in an array
     * - We create an array dp of size amt+1
     * - Where dp[i] = denotes the minimum number of coins needed to make i
     * - dp[amt] - gives us the result
     *
     *  Base case
     *      - dp[0] = 0  as minimum amount of coins needed to make sum 0 are 0
     *      - we can fill the rest of the array with sum+1 or max value as we're looking for minimum
     *
     *  The way we arrived at this solution is by following patterns
     *      - to find dp[i]
     *      - for each coin c1, c2, ... cj.. ..cn
     *      - We find Min(dp[i], dp[i-cj] + 1)
     *      - if we previously found dp[i-cj] and when 1 is added to it as we're choosing it and if it
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
