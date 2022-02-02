package arraysAndStrings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStockWith1BuySell {
    public static void main(String[] args) {
        System.out.println("Expected: 5. Actual: " + getMaxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println("Expected: 0. Actual: " + getMaxProfit(new int[] {7,6,4,3,1}));

        System.out.println("Expected: [1, 6] Actual: " + Arrays.toString(getMaxProfitBuySellValues(new int[] {7,1,5,3,6,4})));
        System.out.println("Expected: [0, 0] Actual: " + Arrays.toString(getMaxProfitBuySellValues(new int[] {7,6,4,3,1})));
    }

    // Refer Notes / https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75924/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    // k = 1
    int getMaxProfit_dynamic(int[] prices) {
        int t_i10 = 0;
        int t_i11 = Integer.MIN_VALUE;
        for (int price: prices) {
            t_i10 = Math.max(t_i10, t_i11 + price);
            t_i11 = Math.max(t_i11, -price);
        }
        return t_i10;
    };


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Note: I've noticed that using Math.max will cause in greater space so best to
     *       resort to using if loop
     * @param prices prices array
     * @return max profit
     */
    public static int getMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // For each iteration, or a price
        for (int currPrice : prices) {
            // We can either find a price that is best time to buy
            if (currPrice < minPrice) {
                minPrice = currPrice;
                // or we can find a price that is the best time to sell
            } else if (currPrice - minPrice > maxProfit) {
                maxProfit = currPrice - minPrice;
            }
        }
        return maxProfit;
    }

    public static int[] getMaxProfitBuySellValues(int[] prices) {
        int[] res = new int[2];
        int minValueBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            if (price < minValueBuy) {
                minValueBuy = price;
                res[0] = price;
            } else if (maxProfit < price - minValueBuy) {
                maxProfit = price - minValueBuy;
                res[1] = price;
            }
        }
        // TODO: fix the case where you can't sell and return [0, 0]

        // return the buying and selling price with max profit
        return res;
    }


}


