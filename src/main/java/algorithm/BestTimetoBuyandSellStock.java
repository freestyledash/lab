package algorithm;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * easy
 *
 * @author zhangyanqi
 * @review 2019-12-18
 * @since 1.0 2019-04-10
 */
public class BestTimetoBuyandSellStock {


    /*
    思路：
    每个价格减去之前最小的价格，找到这个最大的差值
    遍历数组
    记录最小的价格，记录最大的利润
     */

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        //最大利润
        int currentBestProfit = 0;
        //最小价格
        int currentSmallest = prices[0];
        for (int i = 1; i < length; i++) {
            int currentPrice = prices[i];
            if (currentPrice > currentSmallest) {
                int currentProfit = currentPrice - currentSmallest;
                if (currentProfit > currentBestProfit) {
                    currentBestProfit = currentProfit;
                }
            } else {
                currentSmallest = currentPrice;
            }
        }
        return currentBestProfit;
    }

    public static void main(String[] args) {


    }

}
