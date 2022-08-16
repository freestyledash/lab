package main.java.algorithm.tree;

import java.util.*;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * Medium
 * <p>
 * 思路:
 * DFS
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-10
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        if (board == null) {
            return false;
        }
        if (board.length * board[0].length < word.length()) {
            return false;
        }

        List<Candidate> candidateList = new ArrayList<>();
        char first = word.charAt(0);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == first) {
                    candidateList.add(new Candidate(x, y));
                }
            }
        }
        if (candidateList.size() == 0) {
            return false;
        }

        System.out.println(candidateList);
        //dfs
        for (Candidate candidate : candidateList) {
            if (dfs(board, word, 0, candidate.x, candidate.y, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }


    private boolean dfs(char[][] area, String word, int idx, int x, int y, Set<Candidate> currentPathalreadyWent) {
        int maxX = area.length;
        int maxY = area[0].length;
        if (currentPathalreadyWent.contains(new Candidate(x, y))) {
            return false;
        }
        //没有字符串去匹配了,结束,成功
        if (idx == word.length()) {
            System.out.println("匹配成功,结束");
            return true;
        }
        //越界,结束,失败
        if (x >= maxX || x < 0 || y >= maxY || y < 0) {
//            System.out.println("越界,结束,失败");
            return false;
        }
        //没有匹配上,结束,失败;
        if (word.charAt(idx) != area[x][y]) {
//            System.out.println("没有匹配上,结束,失败");
//            System.out.println(word.charAt(idx) + "-" + area[x][y]);
            return false;
        }
        //匹配上了
        System.out.println("search at X:" + x + " Y:" + y);
        System.out.println("MATCH:" + word.charAt(idx));
        currentPathalreadyWent.add(new Candidate(x, y));
        System.out.println(currentPathalreadyWent);
        return
                dfs(area, word, idx + 1, x + 1, y, new HashSet<>(currentPathalreadyWent))
                        || dfs(area, word, idx + 1, x - 1, y, new HashSet<>(currentPathalreadyWent))
                        || dfs(area, word, idx + 1, x, y + 1, new HashSet<>(currentPathalreadyWent))
                        || dfs(area, word, idx + 1, x, y - 1, new HashSet<>(currentPathalreadyWent));

    }

    private static final class Candidate {
        int x;
        int y;

        public Candidate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Candidate) {
                return this.hashCode() == obj.hashCode();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        WordSearch wordSearch = new WordSearch();
        boolean abc = wordSearch.exist(board, "ABCB");
        System.out.println(abc);
        ;
    }

}
