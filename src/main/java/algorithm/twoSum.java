package algorithm;

import java.util.HashMap;

/**
 * leetcode
 * 1. tow Sum
 * https://leetcode.com/problems/two-sum/
 * easy
 *
 * 计算两数之和
 * input array,target
 * output position
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-09
 */
public class twoSum {

    //o(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int l = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < l; i++) {
            for (int ii = i + 1; ii < l; ii++) {
                int a = nums[i];
                int b = nums[ii];
                if (a + b == target) {
                    res[0] = i;
                    res[1] = ii;
                    return res;
                }
            }
        }
        return res;
    }

    //o(n)
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerIntegerHashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int want = target - nums[i];
            Integer integer = integerIntegerHashMap.get(want);
            if (integer != null && integer != i) {
                res[0] = i;
                res[i] = integer;
            }
        }
        return res;
    }
}
