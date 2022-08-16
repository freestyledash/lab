package main.java.algorithm.list;

import org.junit.jupiter.api.Test;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 * Easy
 *
 * 这也太简单了吧~
 * 哈哈哈哈
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/19
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        boolean palindrome = this.isPalindrome(1121);
        System.out.println(palindrome);
    }
}
