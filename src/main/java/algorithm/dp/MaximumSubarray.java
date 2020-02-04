package algorithm.dp;

/**
 * leetcode
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * easy
 * 最长子序列
 *
 * 动态规划
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-16
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (i >= 1) {
                //思路：一定要包括当前的值 那么当前的最优解是 当前值 还是之前的值加上当前值
                dp[i] = Math.max(dp[i - 1] + current, current);
            } else {
                dp[i] = current;
            }
        }
        int best = nums[0];
        for (int i = 0; i < length; i++) {
            int current = dp[i];
            if (current > best) {
                best = current;
            }
        }
        return best;
    }

    public static void main(String[] args) {

    }
}
