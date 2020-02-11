package algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Medium
 * <p>
 * 中序遍历(也是一种BFS)
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class BinaryTreeInorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode treeNode, List<Integer> result) {

        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, result);
        result.add(treeNode.val);
        helper(treeNode.right, result);
    }
}
