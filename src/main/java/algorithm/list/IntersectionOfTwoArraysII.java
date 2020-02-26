package algorithm.list;

import java.util.*;

/**
 * @author zhangyanqi
 * @since 1.0 2020-02-26
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> l = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                l.add(i);
                Integer integer = map.get(i);
                integer--;
                if (integer == 0) {
                    map.remove(i);
                } else {
                    map.put(i, integer);
                }
            }
        }
        int[] result = new int[l.size()];
        int index = 0;
        for (int i : l) {
            result[index] = i;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
