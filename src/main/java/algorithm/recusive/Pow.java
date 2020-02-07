package algorithm.recusive;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * Medium
 * <p>
 * 次方结果
 * 思路：
 * 1.暴力枚举 o(n)
 * 2.divide & recursive
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-07
 */
public class Pow {


    //傻瓜乘法o(n)
    public double myPow(double x, int n) {

        if (n == 0) {
            return 0;
        }

        int abs = Math.abs(n);

        double v = powHelper(x, abs);

        if (n > 0) {
            return v;
        } else {
            return 1 / v;
        }

    }

    double powHelper(double x, int n) {
        if (n == 1) {
            return x;
        }
        return x * powHelper(x, n - 1);
    }

    //divide & conquer  o(n) ---> logn
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        //when n is Integer.MIN_VALUE 优化
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n /= 2;
        }

        //if n is negative make x=1/x and will make n positive
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        //for n is even   like 2^4   ((2*2)^2)
        if (n % 2 == 0) {
            return myPow2(x * x, n / 2);
        } else {
            //for n is odd  like 2^5  ((2^2)^2)*2
            return myPow2(x * x, n / 2) * x;
        }
    }


    public double myPow3(double x, int n) {

        if (n == 0) {
            return x;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;
        while (n >= 1) {
            if (n % 2 == 1) {
                pow *= x;
            }
            x *= x;
            //n = n/2
            n >>= 1;
        }
        return pow;
    }


    public static void main(String[] args) {
        Pow pow = new Pow();
        double v = pow.myPow2(new Double(5), 2);
        System.out.println(v);
    }
}
