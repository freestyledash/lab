package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 * Medium
 * <p>
 * 思路:
 * BFS 耗时间
 * DP
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-02
 */
public class WordBreak {


    //BF BFS bad
    public boolean wordBreak(String s, List<String> wordDict) {
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

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> s = new ArrayList<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        boolean abc = wordBreak.wordBreak("abc", s);
        System.out.println(abc);
    }

}
