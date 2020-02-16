package algorithm.list;

import java.util.*;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 * Medium
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 思路：
 * 类似于3sum，双重for循环+ 两头紧逼
 *
 * leetcode 似乎有点问题
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 4; i++) {
            for (int j = i + 1; j < nums.length - 3; j++) {
                int a = nums[i];
                int b = nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int current = a + b + nums[left] + nums[right];
                    if (current == target) {
                        result.add(Arrays.asList(a, b, nums[left], nums[right]));
                        right--;
                    } else {
                        if (current > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        //去重
        List<List<Integer>> lists = new ArrayList<>();
        Set set = new HashSet<String>();
        for (List l : result) {
            String s = l.toString();
            if (set.contains(s)) {
                continue;
            } else {
                lists.add(l);
                set.add(s);
            }
        }
        System.out.println(lists);
        return lists;
    }


    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        int[] ints = {1, 0, -1, 0, -2, 2};
        int[] ints = {0, 0, 0, 0, 0, 0};
        List<List<Integer>> lists = fourSum.fourSum(ints, 0);
        System.out.println(lists);
    }
}
