package algorithm.tree;

import org.junit.Test;

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
 * medium
 *
 * 思路:
 * 中序遍历魔改
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/16
 */
public class FlattenBinaryTreeToLinkedList {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        reverse(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        if (node.left == null) {
            node.left = node.right;
            node.right = null;
        }
        TreeNode h = helper(node.left);
        if (node.right != null) {
            h.left = node.right;
            node.right = null;
            return helper(h.left);
        } else {
            return h;
        }
    }

    private void reverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        treeNode.right = treeNode.left;
        treeNode.left = null;
        reverse(treeNode.right);
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
        flatten(treeNode1);
        System.out.println("stop");
    }

}
