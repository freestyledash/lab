package main.java.algorithm.dp;

/**
 * Description
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/14
 */
public class 最长湍流子数组 {

    public int maxTurbulenceSize(int[] arr) {

        //边界条件
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2 && arr[0] != arr[1]) {
            return 2;
        }

        //结果
        int result = 1;

        /*
        初始化dp
        每个数字有两个状态
        dp[0] 奇大 偶小
        dp[1] 奇小 偶大

        dp[0][i] 代表 i 数字作为奇大 偶小 模式下的 最长的数字
        dp[0][i] 代表 i 数字作为奇小 偶大 模式下的 最长的数字
         */
        int dp[][] = new int[2][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        /*
        状态转移
         */
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (i % 2 == 0) {
                    //偶数
                    dp[1][i] = dp[1][i - 1] + 1;
                } else {
                    //奇数
                    dp[0][i] = dp[0][i - 1] + 1;
                }
            }
            if (arr[i] < arr[i - 1]) {
                if (i % 2 == 0) {
                    //偶数
                    dp[0][i] = dp[0][i - 1] + 1;
                } else {
                    //奇数
                    dp[1][i] = dp[1][i - 1] + 1;
                }
            }
        }

        /*
        得到结果
         */
        for (int x = 0; x < dp.length; x++) {
            for (int y = 0; y < dp[x].length; y++) {
                result = Math.max(dp[x][y], result);
            }
        }

        return result;

    }

}
