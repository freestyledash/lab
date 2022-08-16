package main.java.algorithm.list;

/**
 * @author zhangyanqi
 * @since 1.0 2020-02-26
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[j + 1] == 0) {
                        break;
                    }
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }
}
