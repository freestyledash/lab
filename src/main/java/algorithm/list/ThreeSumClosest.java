package algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * Medium
 * <p>
 * 思路：
 * 先排序
 * 然后两边向中间夹紧
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        //nlogn
        Arrays.sort(nums);

        int closestSum = 0;
        Integer minDeviation = null;

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = a + nums[left] + nums[right];
                int deviation = target - sum;
                int abs = Math.abs(deviation);
                if (minDeviation == null || abs < minDeviation) {
                    minDeviation = abs;
                    closestSum = sum;
                }
                //调整left 和right
                if (deviation > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] ints = {0, 2, 1, -3};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int i = threeSumClosest.threeSumClosest(ints, 1);
        System.out.println(i);
    }
}
