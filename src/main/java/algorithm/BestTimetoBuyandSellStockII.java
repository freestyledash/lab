package algorithm;


/**
 * LeetCode 122
 * Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * easy
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
        int length = prices.length;
        if (length < 1) {
            return 0;
        }
        int finalProfit = 0;
        int smallestPrice = prices[0];
        for (int i = 1; i < length; i++) {
            int currentPrice = prices[i];
            if (currentPrice > smallestPrice) {
                finalProfit += (currentPrice - smallestPrice);
            }
            smallestPrice = currentPrice;
        }
        return finalProfit;
    }

    public static void main(String[] args) {


    }

}
