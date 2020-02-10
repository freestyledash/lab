package algorithm.tree;

import java.util.*;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Medium
 * <p>
 * Trie树
 * 字典树，又称为单词查找树或者键树，是一种哈希树的变种，典型应用是用于统计和排序大量的字符串
 * 所以经常被用来做文本词频统计
 * <p>
 * 空间换时间，利用字符串的公共前缀来降低查询时间的开销
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-10
 */
public class Trie {

    private HashMap<String, Trie> childrens = new HashMap<>();
    private boolean isTer = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie current = this;
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (current.childrens.containsKey(s)) {
                current = current.childrens.get(s);
            } else {
                Trie trie = new Trie();
                current.childrens.put(s, trie);
                current = trie;
            }
        }
        current.isTer = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            if (!current.childrens.containsKey(s)) {
                return false;
            } else {
                current = current.childrens.get(s);
            }
        }
        return current.isTer;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals(prefix)) {
            return false;
        }
        Trie current = this;
        for (int i = 0; i < prefix.length(); i++) {
            String s = String.valueOf(prefix.charAt(i));
            if (!current.childrens.containsKey(s)) {
                return false;
            } else {
                current = current.childrens.get(s);
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        String[] ss = new String[]{"abc"};
        for (String s : ss) {
            trie.insert(s);
        }
        System.out.println(trie);

//        boolean a = trie.startsWith("a");
//        boolean b = trie.search("ab");
        boolean c = trie.search("abc");
//        boolean d = trie.search("b");
//        boolean e = trie.search("c");
//        System.out.println(a);
//        System.out.println(b);
        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);

    }
}
