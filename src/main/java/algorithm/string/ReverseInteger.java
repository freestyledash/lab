package algorithm.string;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 7. Reverse Integer
 * EASY
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/23
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
        }
        String s = String.valueOf(x);
        if (negative) {
            s = s.substring(1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean first = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0' && first) {
                continue;
            } else {
                stringBuffer.append(s.charAt(i));
                first = false;
            }
        }
        if (negative) {
            Long l = 0 - Long.valueOf(stringBuffer.toString());
            if (l < Integer.MIN_VALUE) {
                return 0;
            } else {
                return l.intValue();
            }
        } else {
            String s1 = stringBuffer.toString();
            if (s1.isEmpty()) {
                return 0;
            }
            Long l = Long.valueOf(stringBuffer.toString());
            if (l > Integer.MAX_VALUE) {
                return 0;
            }
            return l.intValue();
        }
    }

    @Test
    public void test() {
        int reverse = this.reverse(0);
        System.out.println(reverse);
    }
}
