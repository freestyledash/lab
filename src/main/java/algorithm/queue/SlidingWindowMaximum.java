package algorithm.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * hard
 * <p>
 * 滑动窗口中的最大值
 * <p>
 * 思路：
 * 1.使用堆
 * 删除离开的元素
 * 加入新的元素
 * <p>
 * <p>
 * 2.使用双端队列
 * 队列存储最大值的下标
 * 先存k-1个
 * 存的过程中，后来的比前面的大，前面的可以不要了
 * 从第k个开始
 * 先淘汰过去的
 * 存入新的一个，存的过程中，后来的比前面的大，前面的可以不要了
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int k) throws Exception {

        List<Integer> l = new ArrayList<Integer>();

        Deque<Integer> q = new LinkedList<Integer>();

        //处理前k-1个
        int i;
        for (i = 0; i < k - 1; i++) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }// Remove from rear

            // Add new element at rear of queue
            q.addLast(i);
        }

        //此时，i的值为k-1

        //处理后面的第i个
        for (; i < arr.length; i++) {

            //先淘汰过时的
            if (q.peekFirst() != null && q.peekFirst() <= i - k) {
                q.removeFirst();
            }

            //插入新的,类似于处理前k-1的
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);

            //得到
            l.add(arr[q.peekFirst()]);

        }
        //convert to list
        int[] ints = new int[l.size()];
        int m = 0;
        for (int n : l) {
            ints[m] = n;
            m++;
        }
        return ints;
    }

    public static void main(String[] args) throws Exception {
        int[] ints = maxSlidingWindow(new int[]{1, 3, 4, 5, 6, 7, 8, 9}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
