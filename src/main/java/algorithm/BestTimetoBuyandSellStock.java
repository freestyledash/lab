package algorithm;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-10
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<1){
            return 0;
        }
        int bestP = 0;
        int smallest = prices[0];
        for(int i = 1;i < length;i++){
            int current = prices[i];
            if(current>smallest){
                int p = current-smallest;
                if(p>bestP){
                    bestP=p;
                }
            }else{
                smallest = current;
            }
        }
        return bestP;
    }

}
