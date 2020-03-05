package algorithm.dp;

/**
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 * Hard
 * <p>
 * 思路
 * 动态规划
 * 输入两个字符串s,p(p包含通配符，用p去匹配s),
 * 用flag[i][j]表示字符串p从0到i的的子字符串能否匹配s从0到j的子字符串
 *
 * todo 有点难,放在后面做
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-14
 */
public class WildcardMatching {


    /**
     * @param s 待匹配字段
     * @param p 包含通配符
     * @return
     */
    public boolean isMatch(String s, String p) {
        int[][] ints = new int[p.length()][s.length()];


        return false;
    }
}
