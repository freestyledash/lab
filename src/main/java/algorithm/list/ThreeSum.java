package algorithm.list;

import java.util.*;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * Medium
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * 思路：
 * 1.暴力 n^3
 * <p>
 * 2.枚举 a，b + map查询c  n^2 + 1  多一个空间
 * <p>
 * 3.sort find
 * 首先对数组进行排序 nlogn
 * 枚举一个a
 * 从剩下的进行向中间紧逼
 *  紧逼的过程中过滤重复答案
 *  紧逼的过程中如果有答案了，不要break，可能还有答案
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        //过滤重复的答案
        HashSet<String> stringSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int target = 0 - a;
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    String temp = "" + nums[i] + nums[left] + nums[right];
                    if (!stringSet.contains(temp)) {
                        stringSet.add(temp);
                        List<Integer> e = Arrays.asList(nums[i], nums[left], nums[right]);
                        list.add(e);
                    }
                    if (right - left == 1) {
                        break;
                    } else {
                        right--;
                        left++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-2, 0, 1, 1, 2});
//        List<List<Integer>> lists = threeSum.threeSum(new int[]{0, 0, 0, 0});
        System.out.println(lists);
    }

}
