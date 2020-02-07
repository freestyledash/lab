package algorithm.tree;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 最近的公共树
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-06
 */
public class LowestCommonAncestorofABinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (root == null ||
                (root.val >= p.val && root.val <= q.val)) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return root;
        }
    }
}
