package algorithm.list.linkedList;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * meduim
 * 移除末尾第n个元素
 * 思路：
 * use stack
 *
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/11
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> listNodes = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        ListNode toDelete = null;
        ListNode toDeletePre = null;
        while (!listNodes.isEmpty()) {
            ListNode pop = listNodes.pop();
            n--;
            if (n == 0) {
                toDelete = pop;
                continue;
            }
            if (n == -1) {
                toDeletePre = pop;
                break;
            }
        }
        if (toDeletePre != null) {
            toDeletePre.next = toDelete.next;
        } else {
            head = toDelete.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode = this.removeNthFromEnd(listNode0, 2);
        System.out.println("markup");
    }
}
