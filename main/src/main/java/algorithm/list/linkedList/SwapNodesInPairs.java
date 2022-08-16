package main.java.algorithm.list.linkedList;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 24. Swap Nodes in Pairs
 * Medium
 * <p>
 * 基本链表操作
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/21
 */
public class SwapNodesInPairs {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode swapPairs(ListNode head) {
        ListNode result = null;
        ListNode pre = null;
        boolean isFirst = true;
        while (head != null) {
            if (isFirst) {
                if (head.next != null) {
                    result = head.next;
                } else {
                    result = head;
                    break;
                }
                isFirst = false;
            }
            swap(pre, head);
            if (head.next == null || head.next.next == null) {
                break;
            }
            pre = head;
            head = head.next;
        }
        return result;
    }

    private void swap(ListNode preNode, ListNode current) {
        if (current == null || current.next == null) {
            return;
        }
        ListNode next = current.next;
        ListNode nextNext = next.next;
        if (preNode != null) {
            preNode.next = next;
        }
        next.next = current;
        current.next = nextNext;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        ListNode n1 = new ListNode(1);
        ListNode listNode = swapPairs(n1);
        System.out.println(listNode);
    }


}
