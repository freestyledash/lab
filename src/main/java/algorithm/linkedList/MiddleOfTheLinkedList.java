package algorithm.linkedList;

import java.util.Stack;

/**
 * 876.Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * easy
 *
 * 思路：
 * use stack
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/11
 */
public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        Stack<ListNode> listNodes = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        int size = listNodes.size();
        int target = size / 2;
        if (size % 2 != 0) {
            target++;
        }
        while (!listNodes.isEmpty()) {
            ListNode pop = listNodes.pop();
            target--;
            if (target == 0) {
                return pop;
            }
        }
        return null;
    }

}
