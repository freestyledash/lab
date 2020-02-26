package algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode
 * 1. tow Sum
 * https://leetcode.com/problems/two-sum/
 * easy
 * <p>
 * 计算两数之和
 * input array,target
 * output position
 *
 * ps：3sum 4sum 的思路完全不一样
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-09
 */
public class TwoSum {

    //o(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int l = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < l; i++) {
            for (int ii = i + 1; ii < l; ii++) {
                int a = nums[i];
                int b = nums[ii];
                if (a + b == target) {
                    res[0] = i;
                    res[1] = ii;
                    return res;
                }
            }
        }
        return res;
    }

    //o(n) use hashmap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,List<Integer>> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            List l = map.get(nums[i]);
            if(l==null){
                l = new ArrayList<Integer>();
                l.add(i);
                map.put(nums[i],l);
            }else{
                l.add(i);
            }
        }
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> m = map.get(target-n);
            if(m!=null){
                result[0] = i;
                for(int j:m){
                    if(j!=i){
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
