package main.java.algorithm.priorityQueue;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Medium
 * <p>
 * 思路:
 * 堆
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/8
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        PriorityQueue<Node> nodes = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });

        HashMap<Integer, Node> integerNodeHashMap = new HashMap<>();
        for (int i : nums) {
            Node node = integerNodeHashMap.getOrDefault(i, new Node(i, 0));
            node.count++;
            integerNodeHashMap.put(i, node);
        }

        System.out.println(integerNodeHashMap);

        int count = 0;
        for (Node n : integerNodeHashMap.values()) {
            if (count < k) {
                nodes.add(n);
                count++;
            } else if (nodes.peek().count < n.count) {
                nodes.poll();
                nodes.add(n);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!nodes.isEmpty()) {
            list.add(nodes.poll().num);
        }
        Collections.reverse(list);
        return list;
    }


    private class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }


    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4};
        List<Integer> list = this.topKFrequent(arr, 3);
        System.out.println(list);
    }


}