package algorithm.dp;

import org.junit.jupiter.api.Test;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Meduim
 * <p>
 * <p>
 * 思路:
 * DP
 * <p>
 * todo
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-03
 */
public class BestTimeToBuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }

        int[] profit = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            profit[profit.length - i] = prices[i] - prices[i - 1];
        }

        int[] dp = new int[prices.length - 1];
        dp[0] = profit[0];
        dp[1] = Math.max(profit[1] + profit[0], profit[1]);
        for (int i = 2; i < dp.length; i++) {
            if (i - 3 < 0) {
                dp[i] = Math.max(profit[i], profit[i] + dp[i - 1]);
            } else {
                dp[i] = Math.max(profit[i] + dp[i - 1], profit[i] + dp[i - 3]);
            }
        }
        int result = 0;
        for (int i : dp) {
            result = Math.max(i, result);
        }
        return result;
    }

    //test
    @Test
    public void test() {
        int[] ints = {1, 2, 3, 0, 100};
        int i = maxProfit(ints);
        System.out.println(i);

    }
}
