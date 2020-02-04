package algorithm.hash;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * easy
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * <p>
 * 思路：
 * 1.排序,比较 (nlogn)
 * 2.使用hash表
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }

        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            ints[c - 97]++;
        }

        int[] ints2 = new int[26];
        char[] chars2 = t.toCharArray();
        for (char c : chars2) {
            ints2[c - 97]++;
        }
        //compare
        for (int i = 0; i < 26; i++) {
            if (ints[i] != ints2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        boolean anagram = validAnagram.isAnagram("aa", "aaa");
        System.out.println(anagram);
    }
}
