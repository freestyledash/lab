package algorithm.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Hard
 * 思路:
 * 堆
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/05
 */
public class MergekSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        //init
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }

        ListNode result = null;
        ListNode pre = null;

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (result == null) {
                result = poll;
                pre = poll;
            } else {
                pre.next = poll;
                pre = pre.next;
            }
            if (pre.next != null) {
                queue.add(pre.next);
            }
        }

        return result;
    }
}
