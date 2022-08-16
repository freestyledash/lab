package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 * medium
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/7
 */
public class TargetSum {


    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        bfs(nums, 0, S);
        return result;
    }


    private void bfs(int nums[], int lastValue, int target) {
        if (nums.length == 1) {
            int val = nums[0];
            if (lastValue + val == target) {
                result++;
            }
            if (lastValue - val == target) {
                result++;
            }
            return;
        }
        int[] ints = new int[nums.length - 1];
        System.arraycopy(nums, 1, ints, 0, nums.length - 1);
        bfs(ints, lastValue + nums[0], target);
        bfs(ints, lastValue - nums[0], target);
    }

    @Test
    public void test() {
        int[] ints = {1, 1, 1, 1, 1};
        findTargetSumWays(ints, 3);
        System.out.println(result);

    }
}
