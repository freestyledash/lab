package main.java.algorithm.tree;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-09
 */


public class MinimumDepthOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        level++;
        int l = getDepth(node.left, level);
        int r = getDepth(node.right, level);
        return Math.min(l, r);
    }


}
