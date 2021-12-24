package arraysAndStrings;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyStock {
    public static void main(String[] args) {
        System.out.println("Expected: 5. Actual: " + getMaxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println("Expected: 0. Actual: " + getMaxProfit(new int[] {7,6,4,3,1}));
    }

    public static int getMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}


