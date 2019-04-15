package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-10
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> resul = new ArrayList<List<Integer>>();
        List<TreeNode> l1 = new ArrayList<TreeNode>();
        l1.add(root);
        List<TreeNode> l2 = new ArrayList<TreeNode>();
        //判断正在用的1,1为l1,2为l2
        int inUse = 1;
        while (true) {
            if (inUse == 1) {
                if(l1.isEmpty()){
                    break;
                }
                l2.clear();
                ArrayList<Integer> integers = new ArrayList<>();
                for (TreeNode node : l1) {
                    if (node.left != null) {
                        l2.add(node.left);
                    }
                    if (node.right != null) {
                        l2.add(node.right);
                    }
                    integers.add(node.val);
                }
                resul.add(integers);
                inUse = 2;
                continue;
            } else {
                if(l2.isEmpty()){
                    break;
                }
                l1.clear();
                ArrayList<Integer> integers = new ArrayList<>();
                for (TreeNode node : l2) {
                    if (node.left != null) {
                        l1.add(node.left);
                    }
                    if (node.right != null) {
                        l1.add(node.right);
                    }
                    integers.add(node.val);
                }
                resul.add(integers);
                inUse = 1;
            }
        }
        return resul;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


    }
}
