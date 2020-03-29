package algorithm.dp;


/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 * medium
 * https://www.cnblogs.com/grandyang/p/4028713.html
 * <p>
 * <p>
 * 思路:
 * maxDP[n] = Max(minDP[n-1] * nums[n],maxDP[n-1] * nums[n],current)
 * minDP[n] = Min(minDP[n-1] * nums[n],maxDP[n-1] * nums[n],current)
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-14
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            dpMax[i] = getMax(dpMax[i - 1] * current, current, dpMin[i - 1] * current);
            dpMin[i] = getMin(dpMax[i - 1] * current, current, dpMin[i - 1] * current);
        }
        int result = nums[0];
        for (int i = 0; i < dpMax.length; i++) {
            result = Math.max(dpMax[i], result);
        }
        return result;
    }

    private int getMax(int a, int b, int c) {

        if (a < b) {
            a = b;
        }
        if (a < c) {
            a = c;
        }

        return a;
    }

    private int getMin(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;
    }


    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
//        int[] testCase = {1, 0, -1, 0, 3, 4, 6};
        int[] testCase = {-2, 3, -4};
        int i = maximumProductSubarray.maxProduct(testCase);
        System.out.println(i);
    }
}
