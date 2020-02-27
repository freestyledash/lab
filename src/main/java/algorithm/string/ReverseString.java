package algorithm.string;

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-27
 */
public class ReverseString {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length >> 1; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
