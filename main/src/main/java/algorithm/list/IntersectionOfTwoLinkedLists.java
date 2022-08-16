package main.java.algorithm.list;

import java.util.Stack;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-17
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路：双双入栈
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (headA != null) {
            s1.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            s2.add(headB);
            headB = headB.next;
        }

        ListNode head = null;
        while (s1.size() > 0
                && s2.size() > 0
                && s1.peek() == s2.peek()) {
            head = s1.peek();
            s1.pop();
            s2.pop();
        }

        System.out.println(head);

        return head;
    }
}
