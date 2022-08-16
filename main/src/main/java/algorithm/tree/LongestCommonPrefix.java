package main.java.algorithm.tree;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 * Easy
 *
 * BFS
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-16
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new String();
        }
        for (String s : strs) {
            if (strs == null || s.equals("")) {
                return "";
            }
        }

        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (strs[0].length() < i + 1) {
                break;
            }
            boolean ok = true;
            char standard = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() < i + 1) {
                    ok = false;
                    break;
                }
                char c = s.charAt(i);
                if (c != standard) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                resultSb.append(standard);
            }else{
                break;
            }
        }

        return resultSb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lx = new LongestCommonPrefix();
//        String[] strings = {"flower","flow","flight"};
        String[] strings = {"aca", "cba"};

        String s = lx.longestCommonPrefix(strings);
        System.out.println(s);
    }
}
