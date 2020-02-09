package algorithm.tree;

/**
 * leetcode 104
 * https://mp.weixin.qq.com/s/g9RyWpDWfGCnvPvw4res4Q
 * easy
 * 树的最深深度
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-15
 */
public class MaximumDepthofBinaryTree {

    /**
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return getDepth(root,0);
    }

    private int getDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        level++;
        int l = getDepth(node.left, level);
        int r = getDepth(node.right, level);
        return Math.max(l, r);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


