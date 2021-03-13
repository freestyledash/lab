package algorithm.dp;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Meduim
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-tu-miao-dong-jie-fa-by
 * -zi-gei-zi-zu/
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-03
 */
public class BestTimeToBuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {

        //边界条件
        if (prices == null || prices.length <= 0) {
            return 0;
        }

        // 结果
        int result = 0;

        //初始化
        /*
        dp[0]  持有
        dp[1]  卖出 次日不可买入
        dp[2]  不持有 次日可买入

        cell里面的值代表了收益
         */
        int[][] dp = new int[3][prices.length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        dp[2][0] = 0;

        //dp 更新表单
        for (int i = 1; i < prices.length; i++) {
            // 更新 买入的情况
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1] - prices[i]);
            dp[1][i] = dp[0][i - 1] + prices[i];
            dp[2][i] = dp[1][i - 1];
        }

        /*
        得到结果
        最后一天肯定是不持有的
         */
        result = Math.max(dp[2][prices.length - 1], dp[1][prices.length - 1]);

        return result;
    }

}
