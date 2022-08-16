package main.java.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * <p>
 * Medium
 * <p>
 * 思路:
 * 堆
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/5
 */
public class KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        int count = 0;
        for (int i : nums) {
            if (count < k) {
                integers.add(i);
                count++;
            } else {
                if (integers.peek() < i) {
                    integers.poll();
                    integers.add(i);
                }
            }
        }
        return integers.peek();
    }


    @Test
    public void test() {
        int[] ints = {3, 2, 1, 5, 6, 4};
        int kthLargest = this.findKthLargest(ints, 2);
        System.out.println(kthLargest);

    }

}
