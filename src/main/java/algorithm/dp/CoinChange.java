package algorithm.dp;

import java.util.*;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * Medium
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class CoinChange {


    //DFS
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        //去重
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : coins) {
            list.add(i);
        }
        list = new ArrayList<>(new HashSet<>(list));

        //重新放回int[]
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        coins = ints;

        //排序
        Arrays.sort(coins);

        MinCoinCount minCoinCount = new MinCoinCount();
        choose(coins, 0, coins.length - 1, amount, minCoinCount);
        return minCoinCount.count == null ? -1 : minCoinCount.count;
    }

    class MinCoinCount {
        Integer count;
    }

    /**
     * @param coins        candidate
     * @param preCoinCount
     * @param leftAmount
     */
    private void choose(int[] coins, int preCoinCount, int searchStart, int leftAmount, MinCoinCount minCoinCount) {
        //防止太深
        if (minCoinCount.count != null && preCoinCount >= minCoinCount.count) {
            System.out.println("不是最优解" + minCoinCount);
            return;
        }

        //DFS
        for (int i = searchStart; i >= 0; i--) {

            if (leftAmount - coins[i] < coins[0] && leftAmount - coins[i] != 0) {
                System.out.println("跳过");
                continue;
            }

            System.out.println("选择面值:" + coins[i] +
                    " 当前硬币数量:" + (preCoinCount + 1) +
                    " 剩余:" + (leftAmount - coins[i]));

            if (coins[i] == leftAmount) {
                if (minCoinCount.count != null) {
                    minCoinCount.count = Math.min(preCoinCount + 1, minCoinCount.count);
                } else {
                    minCoinCount.count = preCoinCount + 1;
                }
                System.out.println("找到解");
                return;
            }

            choose(
                    coins,
                    preCoinCount + 1,
                    i,
                    leftAmount - coins[i],
                    minCoinCount
            );
        }
    }


    /**
     * 思路：DP
     * dp[i] 代表 凑够i块钱，要使用的张数的最少数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeDP(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //需要凑的钱 = 面额的时候，数量直接=1
                if (dp[i - coin] == 0 || i == coin) {
                    dp[i] = 0;
                } else {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int i1 = coinChange.coinChangeDP(coins, amount);
        System.out.println(i1);

    }
}
