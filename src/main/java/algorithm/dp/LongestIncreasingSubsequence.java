package algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 * Medium
 * <p>
 * 思路:
 * dp[i]代表了必须包含当前i元素的最长上升序列
 * dp[i] = dp[i-1]+1
 * or
 * dp[i] =1;
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/16
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int result = 0;
        for (int i : dp) {
            result = Math.max(i, result);
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    @Test
    public void test() {
        int i = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
