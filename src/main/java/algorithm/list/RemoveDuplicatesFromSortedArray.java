package algorithm.list;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-24
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int index = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[index] = nums[i];
                index++;
            }
            pre = nums[i];
        }
        return index;
    }
}
