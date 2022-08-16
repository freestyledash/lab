package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 33. Search in Rotated Sorted Array
 * Medium
 * <p>
 * 需要时间复杂度logn
 * <p>
 * emmmm
 * 还是得转换为二分查找的问题
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/22
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        //1.找到pivot
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                pivot = i + 1;
                break;
            }
        }
        int[] ints = new int[nums.length];
        System.arraycopy(nums, pivot, ints, 0, nums.length - pivot);
        System.arraycopy(nums, 0, ints, nums.length - pivot, pivot);

        //2.二分查找
        int high = nums.length - 1;
        int low = 0;
        int result = -1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (ints[mid] > target) {
                high = mid - 1;
            } else if (ints[mid] < target) {
                low = mid + 1;
            } else {
                result = mid;
                break;
            }
        }


        if (result == -1) {
            return -1;
        }

        int realRes = result - (nums.length - pivot);


//        System.out.println(pivot);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(ints));
//        System.out.println(target);
//        System.out.println(realRes);


        if (realRes >= 0) {
            return realRes;
        } else {
            return realRes + nums.length;
        }

    }


    @Test
    public void test() {
//        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int[] ints = {1, 3};
        int search = this.search(ints, 1);
        System.out.println(search);
    }


}
