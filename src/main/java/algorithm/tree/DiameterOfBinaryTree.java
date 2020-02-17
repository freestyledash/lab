package algorithm.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Easy
 * 我去，这破题做了这么久
 * <p>
 * 递归思路:
 * f(node) =
 * 中止条件：node.left == null && node.right == null return 1
 * 递归  leftDepth =f(node.left)  rightDepth = f(node.right)
 * return Max(leftDepth,rightDepth)
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-17
 */
public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashSet<Integer> integers = new HashSet<>();
        getMaxDiameter(root, integers);
        int result = 0;
        for (int i : integers) {
            result = Math.max(result, i);
        }
        return result;
    }


    public int getMaxDiameter(TreeNode node, Set<Integer> set) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        int l = 0;
        if (node.left != null) {
            l = getMaxDiameter(node.left, set);
        }
        int r = 0;
        if (node.right != null) {
            r = getMaxDiameter(node.right, set);
        }
        int i = r + l;
        set.add(i);
        return Math.max(l + 1, r + 1);
    }


//    public int getMaxDiameter(TreeNode node, Set<Integer> set) {
//        if (node == null) {
//            return 0;
//        }
//        int left = getMaxDiameter(node.left, set);
//        int right = getMaxDiameter(node.right, set);
//        int e = left + right + 1;
//        set.add(e);
//        return Math.max(left, right) + 1;
//    }

    public static void main(String[] args) {
//
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode()
//        node.left =
//        node.left
    }
}
