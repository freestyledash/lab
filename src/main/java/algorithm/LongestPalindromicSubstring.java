package algorithm;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * medium
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
            eg: * * * *   4 -1 + 4 - 2 = 5 个潜在分界
                从1开始
                基数分界为一个数
                偶数分界为一个间隙
         */
        int total = chars.length * 2 - 3;
        for (int i = 1; i < total; i++) {
            int leftIndex = i / 2;
            int rightIndex = leftIndex + 1;
            while (chars[rightIndex] == chars[leftIndex]) {
                if (leftIndex == 0 || rightIndex == chars.length - 1) {
                    break;
                }
                rightIndex++;
                leftIndex--;
            }
            //compare and save max;
            String current = s.substring(leftIndex, rightIndex + 1);
            if (current.length() > max.length()) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(3 / 2);

        String a = "aba";
        String b = "a";
        String c = "abba";
        String d = "aaaa";
        String e = "";
        String f = "babad";

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        //String result = longestPalindromicSubstring.longestPalindrome(a);
        //String result = longestPalindromicSubstring.longestPalindrome(b);
        //String result = longestPalindromicSubstring.longestPalindrome(c);
        //String result = longestPalindromicSubstring.longestPalindrome(d);
        String result = longestPalindromicSubstring.longestPalindrome(f);

        System.out.println(result);

    }
}
