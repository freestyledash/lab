package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 122
 * Best Time to Buy and Sell Stock II
 * easy
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation:
 * Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-10
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<1){
            return 0;
        }
        int profit = 0;
        int small = prices[0];
        for(int i =1;i<length;i++){
            int current = prices[i];
            if(current>small){
                profit+=(current-small);
            }
            small = current;
        }
        return profit;
    }



}
