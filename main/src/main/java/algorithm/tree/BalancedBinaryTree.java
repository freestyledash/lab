package main.java.algorithm.tree;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * Easy
 * <p>
 * 思路：
 * 查看左子树和右子树的最深深度，如果相差超过1，则不是平衡树
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-08
 */
public class BalancedBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Result {
        boolean r;
    }
    
    public boolean isBalanced(TreeNode root) {
        Result j = new Result();
        j.r = true;
        getLevelAndJudge(root, 0, j);
        return j.r;
    }


    /**
     * 得到当前节点的最深的深度
     * 顺便判断下
     *
     * @param node      被判断的节点
     * @param lastLevel 上一层的深度
     * @param j         结果对象
     * @return 当前节点的深度
     */
    private int getLevelAndJudge(TreeNode node, int lastLevel, Result j) {
        if (node == null) {
            return lastLevel;
        }
        lastLevel++;
        System.out.println("currentLevel:" + lastLevel);
        int l = getLevelAndJudge(node.left, lastLevel, j);
        int r = getLevelAndJudge(node.right, lastLevel, j);

        if (Math.abs(l - r) > 1) {
            j.r = false;
        }

        return Math.max(l, r);
    }
}
