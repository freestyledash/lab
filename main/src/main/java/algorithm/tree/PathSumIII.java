package main.java.algorithm.tree;

import java.util.List;
import java.util.Map;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 * Easy
 * todo
 * 目前实现了Time O(n^2)的还不够
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-17
 */
public class PathSumIII {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //========================================================
    //暴力DFS
    //Time o(n^2) Space O(n)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result =
                helper(root, sum) +
                        pathSum(root.left, sum) +
                        pathSum(root.right, sum);
        return result;
    }


    /**
     * DFS
     * 前序遍历二叉树
     * 经过当前node的能组成sum的个数
     *
     * @param node 以当前节点为根节点
     * @param sum  需要的值
     * @return
     */
    public int helper(TreeNode node, int sum) {
        //一定经过当前节点，和为sum的路径条数（单侧）
        int count = 0;
        if (node == null) {
            return count;
        }
        if (node.val == sum) {
            count++;
        }
        //todo
        //递归
        count += helper(node.left, sum - node.val);
        count += helper(node.right, sum - node.val);
        return count;
    }


    //记录路径的DFS
    //Time O(nlogn)  Space O(n)


    /**
     * 前序遍历二叉树 + 记录路径和
     *
     * @param sum 需要凑得的值
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        //todo
        return 0;
    }

}
