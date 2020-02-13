package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Medium
 * <p>
 * 思路：
 * 层序遍历反过来
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean toRight = true;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<TreeNode> nodes = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            //遍历
            for (TreeNode node : q) {
                list.add(node.val);
                nodes.add(node);
            }
            if (!toRight) {
                for (int i = 0; i < list.size() >> 1; i++) {
                    int temp = list.get(i);
                    list.set(i, list.get(list.size() - 1 - i));
                    list.set(list.size() - 1 - i, temp);
                }
            }
            result.add(list);
            toRight = !toRight;

            q.clear();
            for (TreeNode n : nodes) {
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }

        }
        return result;
    }
}
