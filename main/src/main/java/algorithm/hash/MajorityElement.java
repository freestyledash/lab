package main.java.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 * 出现最多的数目
 * <p>
 * 1.暴力枚举  O(n2)
 * 2.map  key x value count 时间 ，空间都是 O(n)
 * 3.sort nlog 中位数一定是结果
 * 4.divide & recursion nlogn
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-07
 */
public class MajorityElement {

    /**
     * 使用hashmap的方式
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int big = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer i = integerIntegerEntry.getValue();
            if (i > big) {
                big = i;
                result = integerIntegerEntry.getKey();
            }
        }
        return result;
    }
}
