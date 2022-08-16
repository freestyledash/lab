package main.java.algorithm.list;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 * Easy
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-11
 */
public class CountPrimes {

    /*
    数组和下标的对应关系
    intput n
    arr:   2,3,4,5,6....,n-1   长度:n-2
    index: 0,1,2,3,4.....n-3
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int result = 0;
        //假设都是质数
        boolean[] prim = new boolean[n - 2];
        for (int i = 0; i < prim.length; i++) {
            prim[i] = true;
        }

        for (int i = 0; i < prim.length; i++) {
            if (prim[i]) {
                result++;
                //更新后面的数据
                //current 是 当前下标对应的逻辑的值
                int current = i + 2;
                //放大倍数
                int times = 2;
                while (current * times < n) {
                    prim[current * times - 2] = false;
                    times++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int i = countPrimes.countPrimes(10);
        System.out.println(i);


    }

}
