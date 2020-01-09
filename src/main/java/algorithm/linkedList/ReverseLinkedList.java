package algorithm.linkedList;

import java.util.Stack;

/**
 * leetcode
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * easy
 * 翻转链表
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/09
 */
public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        ListNode firstNode = null;
        ListNode currentNode = null;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            if (firstNode == null) {
                firstNode = tempNode;
                currentNode = tempNode;
            } else {
                currentNode.next = tempNode;
                currentNode = tempNode;
            }
        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseList(listNode0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
