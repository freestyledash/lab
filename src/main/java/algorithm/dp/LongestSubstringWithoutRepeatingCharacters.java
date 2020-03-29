package algorithm.dp;

/**
 * leetCode 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Medium
 * <p>
 * 思路:
 * 不重复的String 如果包含当前的newChar,则 subString 不重复的String 然后再加上newChar
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-17
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int max = 0;
        int currentCount = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            String current = sb.toString();
            if (current.contains(String.valueOf(c))) {
                int index = current.indexOf(c);
                String substring = current.substring(index + 1);
                sb = new StringBuilder(substring);
                sb.append(c);
                currentCount = sb.toString().length();
            } else {
                sb.append(c);
                currentCount++;
            }
            if (currentCount > max) {
                max = currentCount;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters
                = new LongestSubstringWithoutRepeatingCharacters();
        int aaaaa = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf");
        System.out.println(aaaaa);
    }

}
