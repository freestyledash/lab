package main.java.algorithm.hash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * Medium
 * <p>
 * 思路:
 * 讲范围数据通过同一个hash算法映射到同一个块中
 * <p>
 * 问题 [1,5] [5,6] 不能算成16
 * 解决方案:
 * 存储长度x2
 * <p>
 * demo:
 * intput [1,5] [5,6]
 * 经过映射
 * {t t t t t t t t ...} 10个true f {t t t t}
 * 整理输出
 * [1,5] [5,6]
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/8
 */
public class MergeIntervals {

    //如果是15 56 则会返回 16 不符合题目要求
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        //计算最大值和最小值
        int min = intervals[0][0];
        int max = intervals[0][0];
        for (int[] i : intervals) {
            for (int j : i) {
                min = Math.min(min, j);
                max = Math.max(max, j);
            }
        }

//        System.out.println(min);
//        System.out.println(max);

        //构造存储数组,将所有的区间数据落到同一个array上
        boolean[] booleans = new boolean[max - min + 1 + max - min];
        for (int[] range : intervals) {
            int begin = range[0];
            int end = range[1];
            for (int idx = (begin - min) * 2; idx <= 2 * (end - min); idx++) {
                booleans[idx] = true;
            }
        }

//        String s = Arrays.toString(booleans);
//        System.out.println(s);

        //记录对连续区间
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                List<Integer> seg = new ArrayList<>();
                while (i < booleans.length && booleans[i]) {
                    seg.add(i);
                    i++;
                }
                lists.add(seg);
            }
        }

        //整理输出
        int[][] result = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            Integer integer = list.get(0);
            Integer integer1 = list.get(list.size() - 1);
            result[i][0] = integer / 2 + min;
            result[i][1] = integer1 / 2 + min;
        }

        return result;
    }


    @Test
    public void test() {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] ints = {{1, 4}, {5, 6}};
        int[][] merge = this.merge(ints);

        for (int[] i : merge) {
            for (int b : i) {
                System.out.print(b);
            }
            System.out.println("===");
        }
    }
}
