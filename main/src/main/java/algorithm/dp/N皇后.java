package main.java.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/14
 */
public class N皇后 {

    public List<List<String>> solveNQueens(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        ArrayList<List<String>> result = new ArrayList<>();

        //构造棋盘
        int[][] playGround = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                //判断第n行
            }

        }

        return result;
    }

}
