package algorithm.tree;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-09
 */
public class LetterCombinationsOfAPhoneNumber {


    Map<String, List<String>> map = new HashMap<>();

    {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), list);
        return list;
    }

    private StringBuilder helper(String digits, int indexToAccount, StringBuilder cur, List<String> result) {
        if (indexToAccount == digits.length()) {
            result.add(cur.toString());
            return cur;
        }

        String c = String.valueOf(digits.charAt(indexToAccount));
        List<String> list = map.get(c);
        for (String s : list) {
            StringBuilder append = new StringBuilder(cur.toString()).append(s);
            helper(digits, indexToAccount + 1, append, result);
        }
        return new StringBuilder("null");
    }


}
