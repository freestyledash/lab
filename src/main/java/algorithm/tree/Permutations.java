package algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/submissions/
 * Medium
 *
 * DFS
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/05
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<Integer> integers = new HashSet<>();
        for (int i : nums) {
            integers.add(i);
        }
        dfs(integers, new ArrayList<>(), result);
        return result;
    }

    private void dfs(Set<Integer> leftNums, List<Integer> temp, List<List<Integer>> result) {
        if (leftNums.size() == 0) {
            result.add(temp);
            return;
        }

        for (int i : leftNums) {
            List<Integer> newTemp = new ArrayList<>(temp);
            HashSet<Integer> newLeft = new HashSet<>(leftNums);
            newTemp.add(i);
            newLeft.remove(i);
            dfs(newLeft, newTemp, result);
        }
    }

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = permutations.permute(ints);
        System.out.println(permute);

    }

}
