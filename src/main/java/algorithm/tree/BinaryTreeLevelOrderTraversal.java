package algorithm.tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * medium
 * <p>
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


}
