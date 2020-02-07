package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * medium
 * <p>
 * 判断一个数是否为搜索二叉树
 * 思路：
 * 1.中序遍历有序升序，不必遍历完所有东西
 * 2.递归判断，每次传入上界和下界
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-06
 */


public class ValidateBinarySearchTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //方法1 遍历，但是不遍历完
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //前序遍历有序
        ArrayList<Integer> list = new ArrayList<>();
        try {
            travers(root, list);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean travers(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            travers(root.left, list);
        }
        if (list.size() == 0 || root.val > list.get(list.size() - 1)) {
            list.add(root.val);
        } else {
            throw new RuntimeException();
        }
        if (root.right != null) {
            travers(root.right, list);
        }
        return true;
    }


    //最快 best 类似于先序遍历
    public boolean isValidBST2(TreeNode root) {
        return judge(root, null, null);
    }

    public boolean judge(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return judge(node.left, min, node.val) && judge(node.right, node.val, max);
    }
}
