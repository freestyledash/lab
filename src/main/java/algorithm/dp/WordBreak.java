package algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 * Medium
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * <p>
 * 思路:
 * BFS 比较耗时间,不推荐
 * DP https://leetcode.com/problems/word-break/discuss/523665/Java-DP-solution-with-explanation
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-02
 */
public class WordBreak {


    //BF BFS bad
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort((e1, e2) -> e1.length() - e2.length());
        System.out.println(wordDict);
        for (String word : wordDict) {
            if (isMatch(s, word)) {
                if (s.length() == word.length()) {
                    return true;
                }
                if (wordBreak(s.substring(word.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isMatch(String s, String toMatch) {
//        System.out.println("match " + s + "-" + toMatch);
        if (s.length() < toMatch.length()) {
            return false;
        }
        if (s.equals(toMatch)) {
            return true;
        }
        String substring = s.substring(0, toMatch.length());
        if (substring.equals(toMatch)) {
            return true;
        }
        return false;
    }


    /**
     * 动态规划完成
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakDp(String s, List<String> wordDict) {
        //dp 的每个位置代表了在这里切一刀下去，能否match dict
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;


        for (int cutPoint = 0; cutPoint < dp.length; cutPoint++) {
            for (String word : wordDict) {
                int i = cutPoint - word.length();
                if (i >= 0 && dp[i] && isMatch(s.substring(i, cutPoint), word)) {
                    dp[cutPoint] = true;
                }
            }
        }
        for (boolean a : dp) {
            System.out.println(a);
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        boolean abc = wordBreak.wordBreak("catsandog", list);
        boolean abc = wordBreak.wordBreakDp("catsandog", list);
        System.out.println(abc);
    }


}
