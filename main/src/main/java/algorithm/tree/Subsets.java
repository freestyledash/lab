package main.java.algorithm.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * Medium
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 枚举素有子集
 * <p>
 * <p>
 * 扩展：
 * Combination 组合
 * Premunation 排列
 *
 * https://www.baeldung.com/java-combinations-algorithm
 * https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-08
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //每个子集内的元素个数
        for (int i = 0; i < nums.length + 1; i++) {
            dfs(nums, i, 0, new ArrayList<>(), result);
        }
        return result;
    }


    /**
     * DFS
     *
     * @param nums   被搜索的的数组
     * @param n      需要的元素个数
     * @param start  搜索起点
     * @param cur    当前已经搜索到的元素集合
     * @param answer 所有结果
     */
    private void dfs(
            int[] nums,
            int n,
            int start,
            List<Integer> cur,
            List<List<Integer>> answer) {
        //停止条件
        if (cur.size() == n) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        //深度优先搜索
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, n, i + 1, cur, answer);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] ints = {1, 2, 3};
        List<List<Integer>> subsets1 = subsets.subsets(ints);
        System.out.println(subsets1);
    }

}
