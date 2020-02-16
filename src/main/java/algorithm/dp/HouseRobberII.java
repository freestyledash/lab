package algorithm.dp;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-16
 */
public class HouseRobberII {


    /**
     * 思路：
     * 将环形转换为线性的
     * 2次dp
     * 第一次包含第一个房子，不包含最后一个
     * 第二次包含第最后一个房子，不包含第一个
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //排除特殊情况
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            if (nums[0] < nums[1]) {
                nums[0] = nums[1];
            }
            if (nums[0] < nums[2]) {
                nums[0] = nums[2];
            }
            return nums[0];
        }
        if (nums.length == 4) {
            return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
        }

        //去掉最后一个
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        dp1[2] = nums[2] + nums[0];
        for (int i = 3; i < dp1.length; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], nums[i] + dp1[i - 3]);
        }

        //去掉第一个
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = nums[2];
        dp2[2] = nums[3] + nums[1];
        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = Math.max(nums[i + 1] + dp2[i - 2], nums[i + 1] + dp2[i - 3]);
        }

        int result = 0;
        for (int i : dp1) {
            result = Math.max(i, result);
        }
        for (int i : dp2) {
            result = Math.max(i, result);
        }

        return result;
    }
}
