package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * Medium
 * <p>
 * 思路1:
 * DFS
 * <p>
 * 思路2:
 * 动态规划
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/5
 */
public class CombinationSum {

    /**
     * dp
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> cans = new ArrayList<>();
        for (int i : candidates) {
            cans.add(i);
        }
        dfs(cans, target, new ArrayList<>(), result, new HashSet<>());
        return result;
    }

    private void dfs(List<Integer> candidates, int target, List<Integer> path, List<List<Integer>> result, Set<String> already) {
        for (int candidate : candidates) {
            ArrayList<Integer> tempPath = new ArrayList<>(path);
            if (candidate == target) {
                tempPath.add(candidate);
                tempPath.sort(Comparator.comparingInt(Integer::intValue));
                String s = tempPath.toString();
                if (already.contains(s)) {
                    continue;
                } else {
                    already.add(s);
                    result.add(tempPath);
                }
            } else if (candidate > target) {
                continue;
            } else {
                tempPath.add(candidate);
                dfs(candidates, target - candidate, tempPath, result, already);
            }
        }
    }


    /**
     * 动态规划
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {

        //init dp
        DPNode[] dp = new DPNode[target];
        for (int i=0;i<dp.length;i++) {
            dp[i] =new DPNode();
        }


        for (int can : candidates) {
            for (int i = 0; i < dp.length; i++) {
                //value 代表了当前需要凑够的数量
                int value = i + 1;
                if (can > value) {
                    //do nothing
                } else if (can == value) {
                    //add new route
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(can);
                    dp[i].path.add(e);

//                    System.out.println("凑够" + value);
//                    System.out.println("dp" + i + "位置的path有:" + dp[i].path);
//                    System.out.println("=======");
                } else {
                    // can < value
                    //copy dp[i - can].path
                    List<List<Integer>> paths = dp[i - can].path;
                    ArrayList<List<Integer>> copy = new ArrayList<>();
                    for (List<Integer> path : paths) {
                        ArrayList<Integer> pathCopy = new ArrayList<>();
                        for (int a : path) {
                            pathCopy.add(a);
                        }
                        copy.add(pathCopy);
                    }

                    //add can
                    for (List<Integer> list : copy) {
                        list.add(can);
                    }

                    dp[i].path.addAll(copy);

//                    System.out.println("凑够" + value);
//                    System.out.println("dp" + (i - can) + "位置的path有:" + dp[i - can].path);
//                    System.out.println("dp" + i + "位置的path有:" + dp[i].path);
//                    System.out.println("=========");

                }
            }
        }
        return dp[dp.length - 1].path;
    }


    private static class DPNode {

        /**
         * 路径
         * this.path  = pre.path add can
         */
        List<List<Integer>> path = new ArrayList<>();


    }

    @Test
    public void testDFS() {
        int[] ints = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = this.combinationSum(ints, target);
        System.out.println(lists);
    }


    @Test
    public void testDP() {
        int[] ints = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = this.combinationSumDP(ints, target);
        System.out.println(lists);
    }
}
