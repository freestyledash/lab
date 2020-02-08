package algorithm.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * Easy
 * 判断树是否对称
 * https://mp.weixin.qq.com/s?__biz=MzIzMDc5Mjg4Mw==&mid=2247484520&idx=1&sn=d7728d32c8cb12ae88014d068867c23b&scene=21#wechat_redirect
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-08
 */
public class SymmetricTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : help(root.left, root.right);
    }

    //思路： left.left == right.right left.right = right.left
    private boolean help(TreeNode l, TreeNode r) {
        if (l == r) {
            return true;
        } else if (l == null || r == null) {
            return false;
        } else if (l.val != r.val) {
            return false;
        }
        return help(l.left, r.right) && help(l.right, r.left);
    }


    /**
     * 一种很直观的想法就是利用层序遍历，看它是不是对称的.
     * <p>
     * 入队顺序依次是, 左子树的左儿子,右子树的右儿子
     * 左子树的右儿子,右子树左右儿子。
     * 这样出队的时候两两检查是不是对称。
     *
     * @param root
     * @return
     */
    private boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // 叶子节点.
            if (left == null && right == null) continue;
            // 其中一个为null 肯定不是
            if (left == null ^ right == null) return false;
            // 值不相同
            if (left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}