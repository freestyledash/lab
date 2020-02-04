package algorithm.list.linkedList;

import org.junit.jupiter.api.Test;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * easy
 *
 * 思路：
 * 两个指针，一个快，一个慢
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/10
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode faster = head;
        ListNode slower = head;
        while (true) {
            ListNode fasterNext = faster.next;
            if (fasterNext == null) {
                return false;
            }
            if (fasterNext == slower) {
                return true;
            }
            //fasterNext
            ListNode fasterNextNext = fasterNext.next;
            if (fasterNextNext == null) {
                return false;
            }
            if (fasterNextNext == slower) {
                return true;
            }
            faster = fasterNextNext;
            slower = slower.next;
        }
    }

    @Test
    public void haveATest() {

    }
}