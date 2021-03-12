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
        matrix[0]  持有
        matrix[1]  卖出 次日不可买入
        matrix[2]  不持有 次日可买入

        cell里面的值代表了收益
         */
        int[][] matrix = new int[3][prices.length];
        matrix[0][0] = -prices[0];
        matrix[1][0] = 0;
        matrix[2][0] = 0;

        //dp 更新表单
        for (int i = 1; i < prices.length; i++) {
            // 更新 买入的情况
            matrix[0][i] = Math.max(matrix[0][i - 1], matrix[2][i - 1] - prices[i]);
            matrix[1][i] = matrix[0][i - 1] + prices[i];
            matrix[2][i] = matrix[1][i - 1];
        }

        //得到结果
        result = Math.max(matrix[2][prices.length - 1], matrix[1][prices.length - 1]);

        return result;
    }

}
