package algorithm.tree;

import javax.swing.tree.TreeNode;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 * Easy
 * 判断两个树是不是一样的
 * <p>
 * 思路：
 * 递归遍历走起
 * 类似于find lowest common ancestor
 * https://mp.weixin.qq.com/s?__biz=MzIzMDc5Mjg4Mw==&mid=2247484516&idx=1&sn=32c1e0d2df5b2e0ed802b76b711522f9&scene=21#wechat_redirect
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-08
 */
public class SameTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && p == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);
        return l && r;
    }
}
