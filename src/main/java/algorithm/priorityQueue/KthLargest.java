package algorithm.priorityQueue;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element.
 * 第K个大的数据
 * <p>
 * 思路：
 * 使用最小堆，控制堆的大小为k，堆顶的元素为第k小的元素
 * 每次新进一个数，如果小于堆顶，则直接丢掉
 * 大于堆顶，丢掉堆顶，加入新元素，调整堆
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-04
 */
public class KthLargest {

    //最小堆
    private PriorityQueue<Integer> priorityQueue;

    int currentCapacity = 0;

    int k = 0;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int i : nums) {
            this.add(i);
        }
    }

    public int add(int val) {
        if (currentCapacity < k) {
            priorityQueue.add(val);
            currentCapacity++;
            return priorityQueue.peek();
        } else {
            Integer peek = priorityQueue.peek();
            if (peek >= val) {
                return peek;
            } else {
                priorityQueue.poll();
                priorityQueue.add(val);
                return priorityQueue.peek();
            }
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3});
        int add = kthLargest.add(4);
        System.out.println(add);
    }


}
