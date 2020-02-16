package algorithm.dp;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 * Easy
 * <p>
 * 思路：DP
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-16
 */
public class HouseRobber {


    public int rob(int[] nums) {
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
            return Math.max(nums[2] + nums[0], nums[1]);
        }

        //房间大于3
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }
        int result = 0;
        for (int i : dp) {
            result = Math.max(i, result);
        }
        return result;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
//        int[] ints = {1, 2, 3};
        int[] ints = {2, 1, 1, 3};
        int rob = houseRobber.rob(ints);
        System.out.println(rob);
    }

}
