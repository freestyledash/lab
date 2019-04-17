package algorithm;


/**
 * @author zhangyanqi
 * @since 1.0 2019-04-17
 * leetcode 3
 * dp[i] = dp[i-1] +1  OR  old - duplicateSequence + 1
 * longest = max(dp)
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
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int aaaaa = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf");
        System.out.println(aaaaa);
    }


}
