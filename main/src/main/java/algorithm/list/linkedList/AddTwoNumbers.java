package main.java.algorithm.list.linkedList;

import java.util.Arrays;
import java.util.List;

/**
 * 2.AddTowNumbers
 * medium
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 * <p>
 * 思路：
 * 从地位加到高位，考虑进位的因素
 *
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
            /*
            计算当前位置
             */
            int a = cl1.val;
            int b = cl2.val;
            int currentResult = a + b;
            if (shouldAdd) {
                currentResult += 1;
            }
            if (currentResult >= 10) {
                currentResult -= 10;
                shouldAdd = true;
            } else {
                shouldAdd = false;
            }
            currentResultNode.val = currentResult;
            /*
            对下一位的判断
            是否为空 & 是否进位
             */
            cl1 = cl1.next;
            cl2 = cl2.next;
            if (cl2 == null && cl1 == null && !shouldAdd) {
                return resultList;
            }
            //先创建一个结果占位符
            currentResultNode = currentResultNode.next = new ListNode(0);
            if (cl2 == null) {
                cl2 = new ListNode(0);
            }
            if (cl1 == null) {
                cl1 = new ListNode(0);
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode build(List<Integer> integers, int position) {
            if (integers == null && integers.isEmpty()) {
                throw new RuntimeException("reject");
            }
            if (integers.get(0) == 0) {
                throw new RuntimeException("reject");
            }
            if (position == integers.size()) {
                return null;
            }
            if (integers.get(position) <= 0) {
                throw new RuntimeException("reject");
            }
            ListNode listNode = new ListNode(integers.get(position));
            ListNode build = build(integers, position + 1);
            if (build == null) {
                return listNode;
            }
            listNode.next = build;
            return listNode;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            while (this.next != null) {
                stringBuilder.append(this.next);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        ListNode build = ListNode.build(Arrays.asList(1, 2, 3, 4, 5), 0);
        System.out.println(build);

    }

}
