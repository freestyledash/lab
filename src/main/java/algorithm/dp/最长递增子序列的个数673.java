package algorithm.dp;

/**
 * Description
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/17
 */
public class 最长递增子序列的个数673 {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] pathCount = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            pathCount[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pathCount[i] = pathCount[j];
                        continue;
                    }
                    if (dp[j] + 1 == dp[i]) {
                        pathCount[i] = pathCount[i] + pathCount[j];
                    }
                }
            }
        }

        int maxDp = 0;
        for (int i = 0; i < dp.length; i++) {
            maxDp = Math.max(maxDp, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxDp) {
                result += pathCount[i];
            }

        }

        return result;
    }

}
