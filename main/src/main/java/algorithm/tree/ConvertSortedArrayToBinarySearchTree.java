package main.java.algorithm.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-14
 */
public class ConvertSortedArrayToBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode helper = helper(nums, 0, nums.length - 1);
        return helper;
    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (high < low) {
            return null;
        }
        int middle = low + ((high - low) >> 1);
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = helper(nums, low, middle - 1);
        treeNode.right = helper(nums, middle + 1, high);
        return treeNode;
    }


    public static void main(String[] args) {

//        int i = 3 + (4 - 3) >> 1;
//        System.out.println(i);

        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
        int[] ints = {1, 3, 5, 7, 9};
        c.sortedArrayToBST(ints);
    }
}
