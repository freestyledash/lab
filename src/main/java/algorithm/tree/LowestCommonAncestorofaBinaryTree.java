package algorithm.tree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 最低的公共祖先节点
 * 思路：
 * 1.从叶子找路径，找最早重合的节点（需要有父亲指针 ，本题不适用） o(n)
 * 2.从根找路径，记录路径
 * best:
 * 3.如果左子树，右子树都有p,q,那么当前节点就是公共的祖先节点，
 * <p>
 * 类似于先序遍历
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-17
 */
public class LowestCommonAncestorofaBinaryTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * @param root
     * @param p
     * @param q
     * @return 当前节点的子树中，是否找到了p或者q或者null，
     * 如果找到了2个，返回它公共的祖先（当前节点），
     * 如果找到了1个，返回这一个的指针（表示找到了一个）
     * 如果没有找到，返回null，
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归中止条件：找到了（root为）p或者q或者root为空（没找到）
        if (root == p || root == q || root == null) {
            return root;
        }

        //开始递归找p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //遍历完一个小树之后，回到这里
        //熟悉下先序遍历的顺序特点
        //得到root节点的查找情况
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            //两边都有p和q的时候
            return root;
        }
    }

    public static void main(String[] args) {


    }


}
