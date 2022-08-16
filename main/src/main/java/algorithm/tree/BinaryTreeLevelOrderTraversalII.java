package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 107. Binary Tree Level Order Traversal II
 * Easy
 *
 *
 * 思路:
 * 层序输出,然后翻转
 * 层序输出的思路有两种:
 *  通过深度遍历来做
 *  通过广度遍历来做
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/21
 */
public class BinaryTreeLevelOrderTraversalII {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        Collections.reverse(result);
        return result;
    }


    private void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            ArrayList<Integer> list = new ArrayList<>();
            result.add(list);
        }
        List<Integer> list = result.get(level);
        list.add(node.val);

        helper(node.left, level + 1, result);
        helper(node.right, level + 1, result);
    }

    @Test
    public void test() {
        /*
        1
        2  5
        34  6
         */
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
        List<List<Integer>> lists = levelOrderBottom(treeNode1);
        System.out.println(lists);
    }
}
