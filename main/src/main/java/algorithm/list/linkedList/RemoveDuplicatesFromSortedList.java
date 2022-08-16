package main.java.algorithm.list.linkedList;

import org.junit.jupiter.api.Test;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Easy
 * 仔细呀!
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/17
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            head.next = head.next.next;
            deleteDuplicates(head);
        } else {
            deleteDuplicates(head.next);
        }
        return head;
    }


    @Test
    public void test() {


    }
}
