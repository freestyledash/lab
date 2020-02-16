package algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * Easy
 * <p>
 * 思路：
 * f(n) =
 * n -1 = 求和 + 判断 + 判重
 * 退出条件：n-1 出现重复 or 得到结果
 * return f(n-1);
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-15
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }

        String s = String.valueOf(n);
        HashSet<String> strings = new HashSet<>();
        return helper(s, strings);
    }


    boolean helper(String num, Set<String> set) {
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            Integer integer = new Integer(String.valueOf(num.charAt(i)));
            result += integer * integer;
        }
        String s = String.valueOf(result);
        if (s.equals("1")) {
            return true;
        } else if (set.contains(s)) {
            return false;
        }
        set.add(s);
        return helper(s, set);
    }
}
