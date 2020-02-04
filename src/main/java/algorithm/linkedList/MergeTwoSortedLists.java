package algorithm.linkedList;

import org.junit.jupiter.api.Test;

/**
 * 21. merge-two-sorted-lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * easy
 *
 * 合并两个有序链表
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/11
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode currentResultNode = resultNode;
        ListNode l1CurrentNode = l1;
        ListNode l2CurrentNode = l2;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (true) {
            if (l2CurrentNode == null && l1CurrentNode != null) {
                currentResultNode.next = new ListNode(l1CurrentNode.val);
                currentResultNode = currentResultNode.next;
                l1CurrentNode = l1CurrentNode.next;
                continue;
            }
            if (l1CurrentNode == null && l2CurrentNode != null) {
                currentResultNode.next = new ListNode(l2CurrentNode.val);
                currentResultNode = currentResultNode.next;
                l2CurrentNode = l2CurrentNode.next;
                continue;
            }
            if (l1CurrentNode == l2CurrentNode) {
                break;
            }
            if (l1CurrentNode.val > l2CurrentNode.val) {
                currentResultNode.next = new ListNode(l2CurrentNode.val);
                currentResultNode = currentResultNode.next;
                l2CurrentNode = l2CurrentNode.next;
                continue;
            } else {
                currentResultNode.next = new ListNode(l1CurrentNode.val);
                currentResultNode = currentResultNode.next;
                l1CurrentNode = l1CurrentNode.next;
                continue;
            }
        }
        return resultNode.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode1_ = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4_ = new ListNode(4);
        listNode1_.next = listNode3;
        listNode3.next = listNode4_;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode1_);
        System.out.println("markUp");
    }
}
