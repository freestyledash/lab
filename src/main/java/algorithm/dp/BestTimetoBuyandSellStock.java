package algorithm.dp;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * easy
 * <p>
 * 买卖一次,找到最佳的收益
 *
 * @author zhangyanqi
 * @review 2019-12-18
 * @since 1.0 2019-04-10
 */
public class BestTimetoBuyandSellStock {


    public static void main(String[] args) {
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        int maxProfit = bestTimetoBuyandSellStock.maxProfit(new int[]{1, 2, 3, 4});
        System.out.println(maxProfit);
    }

    /*
    思路：
    profit = Max(profit,price[n] - minPrice)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        //最小价格
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                result = Math.max(prices[i] - min, result);
            }
        }
        return result;
    }

}
