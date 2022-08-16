package main.java.algorithm.list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * Medium
 * 思路:
 * 1. 暴力查找 最坏 n+n-1+n-2+...+1 -->n^2
 * 2. 取巧搜索
 *
 * @author zhangyanqi
 * @since 1.0 2020/3/7
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        result[result.length - 1] = 0;
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }


    public int[] dailyTemperaturesMoreSmart(int[] T) {
        int[] result = new int[T.length];
        result[result.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; --i) {
            if (T[i] < T[i + 1]) {
                result[i] = 1;
            } else {
                if (result[i + 1] == 0) {
                    result[i] = 0;
                }
                int searchBegin = i + 1;
                int maybeHotterDay = i + 1 + result[i + 1];
                while (T[maybeHotterDay] <= T[i]) {
                    searchBegin = maybeHotterDay;
                    if (result[maybeHotterDay] > 0) {
                        maybeHotterDay = maybeHotterDay + result[maybeHotterDay];
                    } else {
                        break;
                    }
                }
                //search
                for (int a = searchBegin; a <= maybeHotterDay; a++) {
                    if (T[a] > T[i]) {
                        result[i] = a - i;
                    }
                }
            }
        }
        return result;
    }


    @Test
    public void test() {
//        int[] ints = dailyTemperatures(new int[]{1, 5, 2, 3, 6});
        int[] ints = dailyTemperaturesMoreSmart(new int[]{1, 5, 2, 3, 6});
        String s = Arrays.toString(ints);
        System.out.println(s);

    }
}
