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


    /*

    Solution

    maintain two dp array buys and sells, and delta in prices between two days
        buys[i] = max profit when buy stock on day i
        sells[i] = max profit when sell stock on day i
        delta = prices[i] - prices[i-1]
    update sells[i]
        initialize: sells[i] = 0 because no stock to sell at day 0
        when sell stock on day i, [day i-1, day i] could be [buy, sell] or [do nothing, sell]
            if [buy, sell], then val1 = buys[i-1] + prices[i] because we get prices[i] after selling the stock
            if [do nothing, sell], it means that we regret selling stock on previous day and thus val2 = sells[i-1] + delta
            thus sells[i] = max(val1, val2)
    update buys[i]
        initialize: buys[i] = -prices[0] because gain negative profit due to buying a stock
        when buy stock on day i, [day i-2, day i-1, day i] could be [sell, cooldown, buy] or [sth, do nothing, buy]
            if [sell, cooldown, buy], then val1 = sells[i-2] - prices[i] because we need to pay prices[i-1] to buy the stock
            if [sth, do nothing, buy], it means that we regret buying stock on previous day and thus val2 = buys[i-1] - delta
            thus buys[i] = max(val1, val2)
    final max profit should be max(sells)




     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }

        int[] sellAtDay = new int[prices.length];
        int[] buyAtDay = new int[prices.length];

        sellAtDay[0] = 0;
        buyAtDay[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //update sell at i day
            //sell at day i, maybe do nothing at day i-1 maybe buy at i-1
            //do nothing at i-1
            int v1 = sellAtDay[i - 1] + prices[i] - prices[i - 1];
            //buy at i-1
            int v2 = buyAtDay[i - 1] + prices[i];
            sellAtDay[i] = Math.max(v1, v2);

            //update buy at i day
            //[sell, cooldown, buy]
            int m1 = 0;
            if (i - 2 >= 0) {
                m1 = sellAtDay[i - 2] - prices[i];
            } else {
                m1 = -prices[i];
            }
            //[...,do nothing ,buy] 放弃昨天到今天的利润
            int m2 = buyAtDay[i - 1] - (prices[i] - prices[i - 1]);
            buyAtDay[i] = Math.max(m1, m2);
        }
        int result = 0;
        for (int i : sellAtDay) {
            result = Math.max(i, result);
        }
        return result;
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 3, 0, 100};
        int i = maxProfit(ints);
        System.out.println(i);
    }
}
