package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * Medium
 * <p>
 * <p>
 * 思路:
 * 1 暴力DFS
 * 2.DP
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-03
 */
public class UniquePaths {

    int result = 0;


    /**
     * @param m 长
     * @param n 高
     * @return
     */
    public int uniquePathsDFS(int m, int n) {
        //起点:1,1 终点 m,n
        helper(1, 1, m, n);
        return result;
    }

    private void helper(int currentM, int currentN, int m, int n) {
        if (currentN == n && currentM == m) {
            result += 1;
        }

        if (currentM < m) {
            //往右
            helper(currentM + 1, currentN, m, n);
        }
        if (currentN < n) {
            //往下
            helper(currentM, currentN + 1, m, n);
        }
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int a = 1; a < dp.length; a++) {
            for (int b = 1; b < dp[0].length; b++) {
                dp[a][b] = dp[a - 1][b] + dp[a][b - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    @Test
    public void test() {
//        uniquePathsDFS(3, 2);
//        System.out.println(result);

        int i = uniquePaths(3, 2);
        System.out.println(i);
    }
}
