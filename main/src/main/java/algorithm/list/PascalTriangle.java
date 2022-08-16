package main.java.algorithm.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 118. Pascal's Triangle
 * Easy
 * <p>
 * 思路:
 * 观察规则
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/30
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int a = 0; a < i; a++) {
                list.add(1);
            }
            System.out.println(list);
            if (i > 2) {
                List<Integer> pre = res.get(i - 2);
                for (int j = 1; j < list.size() - 1; j++) {
                    list.set(j, pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(list);
        }

        return res;
    }


    @Test
    public void test() {
        List<List<Integer>> generate = generate(3);
        System.out.println(generate);
    }
}
