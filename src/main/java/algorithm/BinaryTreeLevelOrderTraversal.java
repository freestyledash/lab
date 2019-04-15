package algorithm;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-10
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 使用两个list交替存储每一层的节点，停止条件是需要遍历的list empty
     *
     * @param root
     * @return
     */
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

    /**
     * 使用一个队列，每次取出指定长度的数据作为一行
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resul = new LinkedList<List<Integer>>();
        if(root == null){
            return resul;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> line = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode poll = queue.poll();
                if(poll==null){
                    continue;
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                line.add(poll.val);
                size--;
            }
            resul.add(line);
        }
        return resul;
    }

    /**
     *
     * 递归的子问题：遍历当前节点, 对于当前层, 遍历左子树的下一层层,遍历右子树的下一层
     * 递归结束条件: 当前层,当前子树节点是null
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        levelOrderHelper(res, root, 0);
        return res;
    }

    /**
     * @param depth 二叉树的深度
     */
    private void levelOrderHelper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (res.size() <= depth) {
            // 当前层的第一个节点,需要new 一个list来存当前层.
            res.add(new LinkedList<>());
        }
        // depth 层,把当前节点加入
        res.get(depth).add(root.val);
        // 递归的遍历下一层.
        levelOrderHelper(res, root.left, depth + 1);
        levelOrderHelper(res, root.right, depth + 1);
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
