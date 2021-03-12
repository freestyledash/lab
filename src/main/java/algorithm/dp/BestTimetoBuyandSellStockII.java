package algorithm.dp;


import java.util.ArrayList;
import java.util.Map;

/**
 * LeetCode 122
 * Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * easy
 *
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation:
 * Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * 思路：
 * 第二天只要比第一天贵，就赚差价
 *
 * @author zhangyanqi
 * @review 2019-12-18
 * @since 1.0 2019-04-10
 */
public class BestTimetoBuyandSellStockII {

    /*
    思路：
    我可以买无限次
    只要后者的价格高于前者，我就买
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }


    public static void main(String[] args) {
        BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new BestTimetoBuyandSellStockII();
        int maxProfit = bestTimetoBuyandSellStockII.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}
