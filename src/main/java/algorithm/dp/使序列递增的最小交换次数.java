package algorithm.dp;

/**
 * Description
 * https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/16
 */
public class 使序列递增的最小交换次数 {

    public int minSwap(int[] A, int[] B) {
        if (A.length <= 1) {
            return 0;
        }

        int[][] dp = new int[2][A.length];
        dp[0][0] = 0;
        dp[1][0] = 1;

        for (int i = 1; i < A.length; i++) {

            //都大于各自的上一位数,并且也大于对方的上一位数，
            //所以当前 可以换，可以不换
            if (A[i] > A[i - 1] && B[i] > B[i - 1] && A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + 1;
                continue;
            }

            //都大于各自的上一位数,但是不会大于对方的上一位数
            //不能交换 或者  交换，上一个也必须换
            if (A[i] > A[i - 1] && B[i] > B[i - 1] && (A[i] <= B[i - 1] || B[i] <= A[i - 1])) {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1] + 1;
                continue;
            }

            //必须交换，要么上一个换，要么当前换
            if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) {
                dp[0][i] = dp[1][i - 1];
                dp[1][i] = dp[0][i - 1] + 1;
            }

            System.out.println("1");
        }

        return Math.min(dp[0][A.length - 1], dp[1][A.length - 1]);
    }

    public static void main(String[] args) {

        使序列递增的最小交换次数 使序列递增的最小交换次数 = new 使序列递增的最小交换次数();

        /*
        [1,3,5,4]
[1,2,3,7]
         */
        int[] A = new int[]{1,3,5,4};
        int[] B = new int[]{1,2,3,7};
        int i = 使序列递增的最小交换次数.minSwap(
            A, B
        );
        System.out.println(i);

    }
}
