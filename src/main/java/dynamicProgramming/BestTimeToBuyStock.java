package dynamicProgramming;

import java.util.Arrays;

// See notes or https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
public class BestTimeToBuyStock {

    // k = 1
    int getMaxProfit_k1(int[] prices) {
        int t_i10 = 0;
        int t_i11 = Integer.MIN_VALUE;
        for (int price: prices) {
            t_i10 = Math.max(t_i10, t_i11 + price);
            t_i11 = Math.max(t_i11, -price);
        }
        return t_i10;
    };

    // K = ∞ (infinity)
    int getMaxProfit_kInfinity(int[] prices) {
        int t_ik0 = 0;
        int t_ik1 = Integer.MIN_VALUE;
        for (int price: prices) {
            int t_ik0_old = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + price);
            t_ik1 = Math.max(t_ik1, t_ik0_old - price);
        }
        return t_ik0;
    }


    // k = 2
    public int getMaxProfit_k2(int[] prices) {
        int T_i20 = 0;
        int T_i21 = Integer.MIN_VALUE;
        int T_i10 = 0;
        int T_i11 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i20;
    }

    // k = k
    public int getMaxProfit_k(int k, int[] prices) {
        if (k >= prices.length) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }

    // k = ∞ (infinity) with cool down
    public static int getMaxProfitCooldown(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }
}
