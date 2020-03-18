package algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/18
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //退出条件
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //构造root
        int rootVal = postorder[postorder.length - 1];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(rootVal);
        System.out.println("构造:" + treeNode.val);
        if (postorder.length == 1) {
            return treeNode;
        }
        //拆分
        int[] newPosLeft = new int[index];
        int[] newPosRight = new int[postorder.length - 1 - index];
        System.arraycopy(postorder, 0, newPosLeft, 0, newPosLeft.length);
        System.arraycopy(postorder, index, newPosRight, 0, newPosRight.length);

        int[] newInLeft = new int[index];
        System.arraycopy(inorder, 0, newInLeft, 0, newInLeft.length);

        int[] newInRight = new int[inorder.length - 1 - index];
        System.arraycopy(inorder, index + 1, newInRight, 0, newInRight.length);

        System.out.println(Arrays.toString(newInLeft));
        System.out.println(Arrays.toString(newPosLeft));

        System.out.println(Arrays.toString(newInRight));
        System.out.println(Arrays.toString(newPosRight));


        //构造左子树
        treeNode.left = buildTree(newInLeft, newPosLeft);

        //构造右子树
        treeNode.right = buildTree(newInRight, newPosRight);
        return treeNode;
    }


    @Test
    public void test() {

        /*
        inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
         */
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = this.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
