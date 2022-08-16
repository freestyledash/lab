package main.java.algorithm;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * medium
 * 最长回文序列
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/08/19
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //两种情况,pivot is a char pivot is not a char
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return new String("");
        }
        if (chars.length == 1) {
            return s;
        }
        String max = "";
        /*
            结算一共有对少个潜在的分界点
            eg:
                b   a   b   a  d
                  1 2 3 4 5 6 7
                0   1   2   3  4
         */
        int total = chars.length * 2 - 3;
        for (int i = 1; i <= total; i++) {
            //get left index and right index
            int leftIndex;
            int rightIndex;
            if (i % 2 != 0) {
                leftIndex = i / 2;
                rightIndex = leftIndex + 1;
            } else {
                leftIndex = i / 2 - 1;
                rightIndex = leftIndex + 2;
            }
            while (true) {
                if (chars[rightIndex] != chars[leftIndex]) {
                    if (rightIndex - leftIndex != 1) {
                        leftIndex++;
                    }
                    break;
                }
                if (leftIndex == 0 || rightIndex == chars.length - 1) {
                    rightIndex++;
                    break;
                }
                rightIndex++;
                leftIndex--;
            }

            String current = s.substring(leftIndex, rightIndex);
            if (current.length() > max.length()) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        String a = "aba";
        String b = "a";
        String c = "abba";
        String d = "aaaa";
        String e = "";
        String f = "babad";
        String g = "ac";
        String h = "bb";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        //String result = longestPalindromicSubstring.longestPalindrome(a);
        //String result = longestPalindromicSubstring.longestPalindrome(b);
        //String result = longestPalindromicSubstring.longestPalindrome(c);
        //String result = longestPalindromicSubstring.longestPalindrome(d);
        String result = longestPalindromicSubstring.longestPalindrome(h);

        System.out.println(result);

    }
}
