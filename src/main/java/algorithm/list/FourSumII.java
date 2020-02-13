package algorithm.list;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 * Medium
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class FourSumII {


    //排序ABCD，n4 时间复杂度 bad
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            for (int j = 0; j < B.length; j++) {
                int b = B[j];
                for (int k = 0; k < C.length; k++) {
                    int c = C[k];
                    for (int l = 0; l < D.length; l++) {
                        int d = D[l];
                        if (a + b + c + d > 0) {
                            break;
                        }
                        if (a + b + c + d == 0) {
                            System.out.println(a + "&" + b + "&" + c + "&" + d);
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }


    //方法2 使用Map 时间复杂度 o(n2)
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        //get Combin of A and B
        //key 为了得到0还需要的值 value 组合次数
        HashMap<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                sumAB.put(0 - a - b, sumAB.getOrDefault(0 - a - b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                result += sumAB.getOrDefault(c + d, 0);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();
        int i = fourSumII.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        int j = fourSumII.fourSumCount2(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(i);
        System.out.println(j);
    }
}
