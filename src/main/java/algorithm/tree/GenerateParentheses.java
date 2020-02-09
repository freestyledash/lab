package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-09
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        List<String> result = new ArrayList<>();
        help(new StringBuilder(), n, 0, 0, result);
        return result;
    }

    /**
     * 思路：
     * 递归：
     * 条件：数量到了指定数量
     * 递归公式：f(n) =  f(n -1)+ ( or ) n为string的长度
     * 如果n为目标长度，则加入到结果集合中
     *
     * @param sb
     * @param pairCount
     * @param leftParenthesesCount
     * @param rightParenthesesCount
     * @param result
     * @return
     */
    public StringBuilder help(
            StringBuilder sb,
            int pairCount,
            int leftParenthesesCount,
            int rightParenthesesCount,
            List<String> result) {
        //满了,返回结果
        if (leftParenthesesCount == rightParenthesesCount
                && pairCount * 2 == leftParenthesesCount + rightParenthesesCount) {
            result.add(sb.toString());
            return sb;
        }
        //只能加入(
        if (leftParenthesesCount == rightParenthesesCount) {
            sb.append("(");
            return help(sb, pairCount, leftParenthesesCount + 1, rightParenthesesCount, result);
        }
        //只能加入)
        if (leftParenthesesCount == pairCount) {
            sb.append(")");
            return help(sb, pairCount, leftParenthesesCount, rightParenthesesCount + 1, result);
        }
        //()都可以
        StringBuilder s1 = new StringBuilder(sb.toString()).append("(");
        help(s1, pairCount, leftParenthesesCount + 1, rightParenthesesCount, result);

        StringBuilder s2 = new StringBuilder(sb.toString()).append(")");
        return help(s2, pairCount, leftParenthesesCount, rightParenthesesCount + 1, result);
    }
}
