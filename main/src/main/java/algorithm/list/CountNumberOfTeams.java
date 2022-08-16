package main.java.algorithm.list;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 * 1395. Count Number of Teams
 * Medium
 * <p>
 * https://leetcode.com/problems/count-number-of-teams/discuss/554907/Java-Detailed-Explanation-TreeSet-greater-BIT-(Fenwick-Tree)-O(NlogN)
 *
 * @author zhangyanqi
 * @since 1.0 2020/4/1
 */
public class CountNumberOfTeams {


    /**
     * 暴力求解
     *
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int result = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            int a = rating[i];
            for (int j = i + 1; j < rating.length - 1; j++) {
                int b = rating[j];
                for (int k = j + 1; k < rating.length; k++) {
                    int c = rating[k];
                    if (a < b && b < c) {
                        result++;
                    }
                    if (a > b && b > c) {
                        result++;
                    }
                    continue;
                }
            }
        }
        return result;
    }


    @Test
    public void test() {
        int i = this.numTeams(new int[]{2, 5, 3, 4, 1});
        System.out.println(i);
    }
}
