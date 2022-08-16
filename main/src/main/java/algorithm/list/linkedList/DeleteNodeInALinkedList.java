package main.java.algorithm.list.linkedList;

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-15
 */
public class DeleteNodeInALinkedList {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /*
    思路：
    1.后一个复制值到前一个
    2.记录前一个为pre
    3.前一个=后一个

    如果是最后一个，设置最后一个上一个的next为null
     */
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node != null && node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        if (pre != null) {
            pre.next = null;
        }
    }


    public static void main(String[] args) {
        DeleteNodeInALinkedList d = new DeleteNodeInALinkedList();
//        d.deleteNode();
    }

}
