package main.java.algorithm.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyanqi
 * @since 1.0 2020-02-26
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> e : entries) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }

}
