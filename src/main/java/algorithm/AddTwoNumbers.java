package algorithm;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-09
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean shouldAdd = false;
        ListNode cl1 = l1;
        ListNode cl2 = l2;
        ListNode resultList = new ListNode(0);
        ListNode currentResultNode = resultList;
        while (true) {
            int a = cl1.val;
            int b = cl2.val;
            int result = a + b;
            if (shouldAdd) {
                result += 1;
            }
            if (result >= 10) {
                result -= 10;
                shouldAdd = true;
            } else {
                shouldAdd = false;
            }
            currentResultNode.val = result;
            cl1 = cl1.next;
            cl2 = cl2.next;
            if (cl2 == null && cl1 == null && !shouldAdd) {
                return resultList;
            }
            currentResultNode = currentResultNode.next = new ListNode(0);
            if (cl2 == null) {
                cl2 = new ListNode(0);
            }
            if (cl1 == null) {
                cl1 = new ListNode(0);
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
