package algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/submissions/
 * Medium
 * 思路:层序遍历找到最后一行,求和
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/31
 */
public class DeepestLeavesSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> nextLine = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            boolean hasDeeper = false;
            for (TreeNode node : q) {
                if (node.left != null) {
                    hasDeeper = true;
                    nextLine.add(node.left);
                }
                if (node.right != null) {
                    nextLine.add(node.right);
                    hasDeeper = true;
                }
            }
            if (hasDeeper) {
                q.clear();
                q.addAll(nextLine);
                nextLine.clear();
            } else {
                break;
            }
        }
        int result = 0;
        for (TreeNode node : q) {
            result += node.val;
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        node.left = node1;
        int i = this.deepestLeavesSum(node);
        System.out.println(i);
    }
}
