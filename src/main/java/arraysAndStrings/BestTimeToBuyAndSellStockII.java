package arraysAndStrings;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 *  - On each day, you may decide to buy and/or sell the stock.
 *  - You can only hold at most one share of the stock at any time
 *  - However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *  Example 1:
 *      Input: prices = [7,1,5,3,6,4]
 *      Output: 7
 *      Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *          Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *          Total profit is 4 + 3 = 7.
 *
 *  Example 2:
 *     Input: prices = [1,2,3,4,5]
 *     Output: 4
 *     Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *                  Total profit is 4.
 *
 *  Example 3:
 *      Input: prices = [7,6,4,3,1]
 *      Output: 0
 *      Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *  Companies: Facebook, Amazon, Microsoft, Adobe, Google, Apple
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println("Expected: 7 Actual: " + maxProfit(prices1)); // Buy on 1, sell on 5. (4). Buy on 3 sell on 6 (3) => 4+3 = 7
        System.out.println("Expected: 4 Actual: " + maxProfit(prices2)); // buy on 1, sell on 5 => 4
        System.out.println("Expected: 0 Actual: " + maxProfit(prices3)); // 0 profit
    }

    /**
     * Approach: Sum of all positive differences
     *   - We need to consider every peak immediately following a valley to maximize the profit
     *   - In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to overall lesser profit
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param prices int[] prices on all days
     * @return int max profit
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit = maxProfit + (prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }

    /**
     * Approach:
     *  - If you plot a graph with days on x axis and prices on y axis
     *  - Total profit = ∑ (height(peak i)) - (height(valley i))
     *                   i
     *  - We need to consider every peak immediately following a valley to maximize the profit
     *  - In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to overall lesser profit
     *  Algorithm
     *      - We iterate over the array till the last but-one-element
     *      - We keep track of peak and valley
     *      - Once we found a peak (the next value is lower), update it
     *      - Once we found a valley (the next value is higher), update it
     *      - Add the difference of peak-valley to result
     *
     *  Time Complexity: O(N) - Single Pass
     *  Space Complexity: O(1)
     * @param prices int[] prices on each day
     * @return int max profit by buying and selling on different days
     */
    public static int maxProfit_peakValleyApproach(int[] prices) {
        int maxProfit = 0;

        int i = 0;
        int peak = prices[0];
        int valley = prices[0];

        // Traverse till last-but-one element
        while (i < prices.length-1) {
            // During PEAK -  While the price on next day is LOWER  - V.V.I.P - GET To First Vall
            while (i < prices.length-1 &&  prices[i+1] <= prices[i]) {
                i++;
            }
            // We've found a valley
            valley=prices[i];
            // During VALLEY - While the price on next day is HIGHER
            while (i < prices.length-1 && prices[i+1] >= prices[i]){
                i++;
            }
            peak = prices[i];
            maxProfit = maxProfit + (peak - valley);
        }
        return maxProfit;
    }
}
