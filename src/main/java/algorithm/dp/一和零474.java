package algorithm.dp;

/**
 * Description
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 *
 * 思路:
 * https://leetcode-cn.com/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/12
 */
public class 一和零474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int result = 0;

        if (strs == null || strs.length == 0) {
            return 0;
        }

        int dp[][] = new int[m][n];

        for (String str : strs) {
            int count0 = 0;
            int count1 = 1;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == '1') {
                    count1++;
                } else {
                    count0++;
                }
            }
            for (int i = m - 1; i >= count0 - 1; i--) {
                for (int j = n - 1; j >= count1 - 1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
