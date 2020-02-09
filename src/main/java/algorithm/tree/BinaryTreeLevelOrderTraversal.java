package algorithm.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * medium
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 思路：
 * 递归遍历，遍历的时候，记住层数
 *
 * @author zhangyanqi
 * @review 2019-12-18
 * @since 1.0 2019-04-10
 */
public class BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }


    public void helper(TreeNode treeNode, List<List<Integer>> list, int i) {
        if (treeNode == null) {
            return;
        }

        if (list.size() < i + 1) {
            list.add(new ArrayList<>());
        }
        List<Integer> integers = list.get(i);
        integers.add(treeNode.val);

        helper(treeNode.left, list, i + 1);
        helper(treeNode.right, list, i + 1);
    }


    //BFS
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        } else {
            q.add(root);
        }
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode treeNode : q) {
                list.add(treeNode.val);
            }
            result.add(list);
            int i = list.size();
            while (i > 0) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                i--;
            }
        }
        return result;
    }


}
