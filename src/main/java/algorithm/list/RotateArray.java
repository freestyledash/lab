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
        for(int start = 0; start < nums.length; start++){
            int p = start;
            int pV = nums[start];
            do{
                int nP = getNewPosition(nums.length,p,k);
                int temp  = nums[nP];
                nums[nP] = pV;
                p = nP;
                pV = temp;
            }while(start != p);
        }
    }

    private int getNewPosition(int length, int originPostion,int k){
        return ( originPostion + k ) % length;
    }
}
