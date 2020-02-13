package algorithm.tree;

import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * <p>
 * 思路：
 * 关键：
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[0]);
        int sepratePoint = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                sepratePoint = i;
                break;
            }
        }
        int[] leftPreOrder = new int[sepratePoint];
        int[] rightPreOrder = new int[inorder.length - 1 - sepratePoint];
        int[] leftInOrder = new int[sepratePoint];
        int[] rightInOrder = new int[inorder.length - 1 - sepratePoint];

        for (int i = 0; i < leftPreOrder.length; i++) {
            leftPreOrder[i] = preorder[i + 1];
        }

        for (int i = 0; i < rightPreOrder.length; i++) {
            rightPreOrder[i] = preorder[sepratePoint + 1 + i];
        }

        for (int i = 0; i < leftInOrder.length; i++) {
            leftInOrder[i] = inorder[i];
        }

        for (int i = 0; i < rightInOrder.length; i++) {
            rightInOrder[i] = inorder[sepratePoint + 1 + i];
        }

        //中序和先序的数组大小应该相同的
        treeNode.left = buildTree(leftPreOrder, leftInOrder);
        treeNode.right = buildTree(rightPreOrder, rightInOrder);

        return treeNode;
    }
}
