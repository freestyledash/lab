package algorithm.list;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 * easy
 * <p>
 * 思路：
 * 注意最后一位数是否需要进位 例如 9999
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-26
 */
public class PlusOne {


    public int[] plusOne(int[] digits) {
        boolean forward = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (forward) {
                digits[i]++;
                if (digits[i] >= 10) {
                    digits[i] %= 10;
                    forward = true;
                } else {
                    forward = false;
                }
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
