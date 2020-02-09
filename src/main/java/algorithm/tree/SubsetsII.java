package algorithm.tree;


import java.util.*;

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 * Medium
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * 枚举素有子集，有重复元素，需要去重一下
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-08
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //每个子集内的元素个数
        for (int i = 0; i < nums.length + 1; i++) {
            dfs(nums, i, 0, new ArrayList<>(), result);
        }
        HashSet<String> hashSet = new HashSet();
        Iterator<List<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            String hash = hash(next);
            if (hashSet.contains(hash)) {
                iterator.remove();
            } else {
                hashSet.add(hash);
            }
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
            ArrayList<Integer> e = new ArrayList<>(cur);
            e.sort((a, b) -> a - b);
            answer.add(e);
            return;
        }

        //深度优先搜索
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, n, i + 1, cur, answer);
            cur.remove(cur.size() - 1);
        }
    }

    public String hash(List<Integer> ints) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ints) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

}
