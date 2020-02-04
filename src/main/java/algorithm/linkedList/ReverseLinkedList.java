package algorithm.linkedList;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * leetcode
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * easy
 * 翻转链表
 *
 * 思路：使用stack
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

    //none-recursive
    public ListNode reverseListNoneRecursive(ListNode head) {
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

    /**
     * recursive reverse linkedNode
     * thought:
     * 当前节点成为已经翻转的后续节点的tail
     *
     * @param head 头结点
     * @return
     */
    static ListNode last = null;
    static ListNode first = null;

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (first == null) {
            first = head;
        }
        if (head.next == null) {
            last = head;
            return head;
        }
        ListNode listNode = reverseListRecursive(head.next);
        listNode.next = head;
        //防止成环
        head.next = null;
        if (head == first) {
            return last;
        } else {
            return head;
        }
    }

    @Test
    public void testReverseListRecursive() {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        //ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        //listNode1.next = listNode2;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseListRecursive(listNode0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    @Test
    public void testReverseListNoneRecursive() {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseListNoneRecursive(listNode0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
