package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-10
 * 122. Best Time to Buy and Sell Stock II
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
