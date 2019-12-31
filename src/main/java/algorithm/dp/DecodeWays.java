package algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * leetcode
 * 91. Decode Ways
 * medium
 *
 * https://leetcode.com/problems/decode-ways/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/12/29
 */
public class DecodeWays {

    public int numDecodings(String s) {
        //todo
        return 0;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "A", "B", "B", "B", "C", "C", "D");
        //代表index前面，有几个一样的
        int[] dp = new int[strings.size()];
        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).equals(strings.get(i - 1))) {
                System.out.println("合并：" + (i - 1 - dp[i - 1]) + "," + (i - 1));
                if (i == strings.size() - 1) {
                    System.out.println("特殊合并：" + i + "," + i);
                }
            } else {
                if (i == strings.size() - 1) {
                    System.out.println("特殊合并：" + (i - 1 - dp[i - 1]) + "," + i);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
    }
}
