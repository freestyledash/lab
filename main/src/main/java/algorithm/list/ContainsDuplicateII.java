package main.java.algorithm.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Easy
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-25
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //convert to map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(nums[i], index);
            } else {
                list.add(i);
            }
        }

        //traverse
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            for (int i = 1; i < value.size(); i++) {
                Integer idx1 = value.get(i - 1);
                Integer idx2 = value.get(i);
                if (idx2 - idx1 <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void test() {
//        nums = [1,2,3,1,2,3], k = 2
        int[] ints = new int[]{1, 2, 3, 1, 2, 3};
        boolean b = this.containsNearbyDuplicate(ints, 2);
        System.out.println(b);

        //nums = [1,0,1,1], k = 1
        int[] ints2 = new int[]{1, 0, 1, 1};
        boolean b2 = this.containsNearbyDuplicate(ints2, 1);
        System.out.println(b2);
    }
}
