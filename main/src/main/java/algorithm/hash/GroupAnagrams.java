package main.java.algorithm.hash;

import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * medium
 * Given an array of strings, group anagrams together.
 * <p>
 * 思路：
 * 自己写hash 函数
 * map key:metadata of anagram    value Anagrams
 * metadata of anagram = convert string to int[] then to String
 * 利用字母就26个的原理
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-07
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            int[] ints = new int[26];
            for (char c : chars) {
                ints[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                sb.append(i);
            }
            String string = sb.toString();
            if (map.containsKey(string)) {
                List<String> strings = map.get(string);
                strings.add(s);
            } else {
                ArrayList<String> stringArrayList = new ArrayList<>();
                stringArrayList.add(s);
                map.put(string, stringArrayList);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> integerListEntry : map.entrySet()) {
            list.add(integerListEntry.getValue());
        }
        return list;
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
