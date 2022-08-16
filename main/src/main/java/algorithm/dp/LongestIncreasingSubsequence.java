package main.java.algorithm.dp;

import org.junit.Test;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 * Medium
 * <p>
 *
 * 思路:
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai
 * -gui-hua-2/
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/16
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int result = 0;

        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        for (int i : dp) {
            if (i > result) {
                result = i;
            }
        }

        return result;

    }

    @Test
    public void test() {
        int i = lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
