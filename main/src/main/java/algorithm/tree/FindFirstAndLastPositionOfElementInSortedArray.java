package main.java.algorithm.tree;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Medium
 *
 * 思路:二分查找
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/05
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);

        //find last
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    result[1] = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    result[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 5, 5, 5, 6, 9};
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray
            = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] ints1 = findFirstAndLastPositionOfElementInSortedArray.searchRange(ints, 5);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

}
