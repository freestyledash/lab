package algorithm.tree;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Hard
 *
 * 思路:
 * 后续遍历
 * 收回到一个节点的时候
 *  1. 判断是否要更新结果
 *  2. 得到返回给上层的结果值
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class BinaryTreeMaximumPathSum {

    int result = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return result;
        }
        result = root.val;
        int helper = helper(root);
        return result;
    }


    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (root.val > result) {
                result = root.val;
            }
            if (root.val > 0) {
                return root.val;
            }
            return 0;
        }

        int right = 0;
        if (root.right != null) {
            right = helper(root.right);
        }

        int left = 0;
        if (root.left != null) {
            left = helper(root.left);
        }

        int currentResult = right + left + root.val;
        if (currentResult > result) {
            result = currentResult;
        }
        //return Math.max(right, left) + root.val;
        return max(right + root.val, left + root.val, root.val, 0);
    }

    private int max(int a, int b, int c, int d) {
        if (a > b) {
            b = a;
        }
        if (b > c) {
            c = b;
        }
        if (d > c) {
            return d;
        }
        return c;
    }
}
