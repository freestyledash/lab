package algorithm.list;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * Easy
 *
 * 很有意思的一道题
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-24
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        //确定k的取值规律
        k = k % nums.length;
        //分析特点：从一个点出发，最终会回到这个点上
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int p = start;
            int pV = nums[start];
            do {
                int nP = getNewPosition(nums.length, p, k);
                int temp = nums[nP];
                nums[nP] = pV;
                p = nP;
                pV = temp;
                count++;
            } while (start != p);
        }
    }

    private int getNewPosition(int length, int originPosition, int k) {
        return (originPosition + k) % length;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] i = new int[] {1, 2, 3};
        rotateArray.rotate(i, 1);
        for (int m : i) {
            System.out.println(m);
        }
    }
}
