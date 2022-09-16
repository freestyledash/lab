package main.java.algorithm.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
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

    /**
     * 二叉搜索树中续遍历是有序数组
     *
     * @param root
     * @param list
     * @return
     */
    public boolean travers(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            travers(root.left, list);
        }
        //当前值比
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


    //方法2 最快 best 类似于先序遍历
    public boolean isValidBST2(TreeNode root) {
        return judge(root, null, null);
    }

    /**
     * @param node 需要判断的节点
     * @param min  合理的最小值
     * @param max  合理的最大值
     * @return 是否合理
     */
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

    public static class 数轴开关 {


        public static void main(String[] args) {
            StepResult stepResult = new StepResult();
            stepResult.totalCostTime = 0;
            stepResult.restCandidate = Lists.newArrayList(-3, -1, 1, 2, 3);
            stepResult.pos = 0;
            stepResult.rest = 3;

            ArrayList<Integer> results = new ArrayList<>();

            search(stepResult, results);

            int result = Integer.MAX_VALUE;
            for (Integer a : results) {
                result = Math.min(a, result);
            }

            System.out.println(result);
        }


        static class StepResult {

            public int totalCostTime = 0;

            public List<Integer> restCandidate;

            public Integer pos = 0;

            public int rest = 3;

        }


        /**
         * 搜索
         */
        public static void search(StepResult lastResult, final List<Integer> result) {

            if (lastResult.rest == 0) {
                result.add(lastResult.totalCostTime);
            }

            Integer leftClosingPos = null;
            Integer rightClosingPos = null;
            boolean findRight = false;

            for (int i = 0; i < lastResult.restCandidate.size(); i++) {
                Integer current = lastResult.restCandidate.get(i);
                if (!findRight && current > lastResult.pos) {
                    findRight = true;
                    rightClosingPos = current;
                }

                if (current < lastResult.pos) {
                    leftClosingPos = current;
                }
            }

            System.out.println("当前位置" + lastResult.pos + " 左边:" + leftClosingPos + "右边 " + rightClosingPos);


            //往左走
            if (leftClosingPos != null) {
                int timeCostTime = lastResult.pos - leftClosingPos;

                ArrayList<Integer> newCandidate = new ArrayList<>();
                for (Integer integer : lastResult.restCandidate) {
                    newCandidate.add(integer);
                }
                Iterator<Integer> iterator = newCandidate.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    if (next.equals(leftClosingPos)) {
                        iterator.remove();
                        break;
                    }
                }

                StepResult newStepResult = new StepResult();
                newStepResult.totalCostTime = lastResult.totalCostTime + timeCostTime;
                newStepResult.pos = leftClosingPos;
                newStepResult.restCandidate = newCandidate;
                newStepResult.rest = lastResult.rest - 1;

                System.out.println("<-");
                search(newStepResult, result);
            }

            //往右
            if (rightClosingPos != null) {
                int timeCostTime = rightClosingPos - lastResult.pos;

                ArrayList<Integer> newCandidate = new ArrayList<>();
                for (Integer integer : lastResult.restCandidate) {
                    newCandidate.add(integer);
                }

                Iterator<Integer> iterator = newCandidate.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    if (next.equals(rightClosingPos)) {
                        iterator.remove();
                        break;
                    }
                }

                StepResult newStepResult = new StepResult();
                newStepResult.totalCostTime = lastResult.totalCostTime + timeCostTime;
                newStepResult.pos = rightClosingPos;
                newStepResult.rest = lastResult.rest - 1;
                newStepResult.restCandidate = newCandidate;

                System.out.println("->");
                search(newStepResult, result);
            }

        }


    }
}
