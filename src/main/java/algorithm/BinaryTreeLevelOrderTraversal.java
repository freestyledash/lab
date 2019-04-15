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
        //层数
        int level = 1;
        //一层的个数
        int size = new Double(Math.pow(2, level - 1)).intValue();
        //当前多少个
        int count = 1;
        int index = 0;
        List result = new ArrayList<List<Integer>>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while (true) {
            if (size == count) {
                //裁剪
                List<TreeNode> temp = list.subList(list.size() - size, list.size());
                ArrayList<Integer> integers = new ArrayList<>();
                for(TreeNode node:temp){
                    integers.add(node.val);
                }
                result.add(integers);
                count = 0;
                level ++;
                size = new Double(Math.pow(2, level - 1)).intValue();
            }
            TreeNode left = list.get(index).left;
            TreeNode right = list.get(index).right;
            list.add(left);
            list.add(right);
            index++;
            size += 2;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
