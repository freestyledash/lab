package algorithm.priorityQueue;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

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
 * 堆顶元素为结果
 * 2.使用双端队列
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) throws Exception {
        int currentLength = 0;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (currentLength < k - 1) {
                integers.add(num);
                currentLength++;
            } else {
                //insert new
                integers.add(num);

                //get max
                int max = integers.peek();
                for (int e : integers) {
                    max = e > max ? e : max;
                }
                //weed out oldest
                integers.take();
                //return
                list.add(max);
            }
        }
        int[] ints = new int[list.size()];
        int i = -1;
        for (int e : list) {
            i++;
            ints[i] = e;
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
