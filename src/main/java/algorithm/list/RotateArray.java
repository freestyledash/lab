package algorithm.list;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * Easy
 * todo
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-24
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k =  k % nums.length;
        int pre = nums[0];
        int pos = 0;
        for(int i = 0; i<nums.length ;i++){
            int newPos = getNewPosition(nums.length,pos,k);
            int temp = nums[newPos];
            nums[newPos] = pre;
            pre = temp;
            pos = newPos;
        }
    }

    private int getNewPosition(int length,int originPostion,int k){
        return ( originPostion + k ) % (length-1);
    }
}
