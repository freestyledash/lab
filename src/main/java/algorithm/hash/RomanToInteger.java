package algorithm.hash;

import java.util.*;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * Easy
 * <p>
 * todo
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-29
 */
public class RomanToInteger {


    public int romanToInt(String s) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        char[] arr = s.toCharArray();
        for (char i : arr) {
            if (stack.isEmpty()) {
                stack.push(1);
            }
        }
        int result = 0;

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int xxx = romanToInteger.romanToInt("IV");
        System.out.println(xxx);
    }
}
