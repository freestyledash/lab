package algorithm.dp;

/**
 * leetcode
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * easy
 * 爬梯子
 * 思路：
 * 动态规划
 * dp[i]=dp[i−1]+dp[i−2]
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/12/28
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        //represent count of ways to reach to the n level stair
        int[] dp = new int[n];
        //init
        dp[0] = 1;
        dp[1] = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            result = Math.max(dp[i], dp[i - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int i = climbingStairs.climbStairs(4);
        System.out.println(i);

    }
}
