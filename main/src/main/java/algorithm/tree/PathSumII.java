package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * 113. Path Sum II
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/21
 */
public class PathSumII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, sum, null, lists);
        return lists;
    }

    private void helper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (current == null) {
            current = new ArrayList<>();
        }
        if (root.left == null && root.right == null && root.val == sum) {
            current.add(root.val);
            result.add(current);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>(current);
        list.add(root.val);
        helper(root.left, sum - root.val, list, result);
        ArrayList<Integer> list2 = new ArrayList<>(current);
        list2.add(root.val);
        helper(root.right, sum - root.val, list2, result);
    }


    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode1.right = treeNode5;
        treeNode5.right = treeNode6;
        List<List<Integer>> lists = this.pathSum(treeNode1, 7);
        System.out.println(lists);

    }

}
