package algorithm.dp;

/**
 * LeetCode
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 * hard
 *
 * todo 结题思路不清晰
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * 动态规划
 * http://cs-cjl.com/2016/09_24_leetcode_32_longest_valid_parentheses
 * https://www.cnblogs.com/f91og/p/9411135.html
 * https://zhuanlan.zhihu.com/p/89711292
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/12/28
 */
public class LongestValidParentheses {

    /**
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 1) {
            return 0;
        }
        //record unmatched left parenthesis
        int unmatchedLeftParenthesis = 0;
        //dp[i] 表示以S[i]作为结尾的最长合法字符串的长度
        int[] dp = new int[s.length()];
        //init
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                unmatchedLeftParenthesis++;
            } else if (unmatchedLeftParenthesis > 0 && i > 0) {
                unmatchedLeftParenthesis--;
                dp[i] = dp[i - 1] + 2;
                //此时dp[i+1]不一定是所有的，需要看看前面的是否有 （关键）
                dp[i] += dp[i - 1 - dp[i - 1]];
            }
        }
        //get max
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "(()((())(())";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int i = longestValidParentheses.longestValidParentheses(test);
        System.out.println(i);
    }
}
