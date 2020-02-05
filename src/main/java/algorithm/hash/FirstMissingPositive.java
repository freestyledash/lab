package algorithm.hash;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * hard
 * 消失的第一个正整数
 *
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-09
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        //特殊情况判断
        int length = nums.length;
        if (length == 0) {
            return 1;
        }

        for (int i = 0; i < length; i++) {
            int current = nums[i];
            //把每个数 n 和数组的 n-1 的位置上的数进行交换
            if (current <= length && current > 0 && current != i + 1) {
                int temp = nums[current - 1];
                if (temp == current) {
                    continue;
                }
                //交换 key
                nums[current - 1] = current;
                nums[i] = temp;
                i--;
            }
        }
        //遍历检查
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (current != i + 1) {
                return i + 1;
            }
            if (i == length - 1) {
                return length + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        int i = new FirstMissingPositive().firstMissingPositive(ints);
        System.out.println(i);
    }
}
