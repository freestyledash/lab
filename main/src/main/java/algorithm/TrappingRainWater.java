package algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * <p>
 * 思路
 * 1. 按照行扫描
 * 2. 按列扫描
 * 动态规划
 * stack
 */

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 2, 1};
        solveByDP(input);
        System.out.println("-----------");
        solveByStack(input);
    }

    /**
     * 首先用两个数组，
     * max_left [i] 代表第 i 列左边最高的墙的高度，
     * max_right[i] 代表第 i 列右边最高的墙的高度。
     * （一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的
     * <p>
     * 有趣的地方:
     * 从左往右
     * 从右往左
     * 得到一个点,左右最高的柱子
     */
    public static int solveByDP(int[] height) {
        int[] dpMaxLeft = new int[height.length];
        dpMaxLeft[0] = height[0];
        int[] dpMaxRight = new int[height.length];
        dpMaxRight[height.length - 1] = height[height.length - 1];

        //从左往右
        for (int i = 1; i < height.length; i++) {
            dpMaxLeft[i] = Math.max(dpMaxLeft[i - 1], height[i]);
        }

        //从右往左
        for (int i = height.length - 2; i > 0; i--) {
            dpMaxRight[i] = Math.max(dpMaxRight[i + 1], height[i]);
        }

        System.out.println("=======");
        for (int i : dpMaxLeft) {
            System.out.print(i + "-");
        }
        System.out.println("=======");
        for (int i : dpMaxRight) {
            System.out.print(i + "-");
        }
        System.out.println("=======");


        int result = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int current = height[i];
            int leftMax = dpMaxLeft[i];
            int rightMax = dpMaxRight[i];
            int currentWaterUpLimit = Math.min(leftMax, rightMax);

            if (currentWaterUpLimit > current) {
                result += (currentWaterUpLimit - current);
            }
        }

        System.out.println(result);
        return result;
    }

    /**
     * 单调栈
     */
    public static int solveByStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int current : height) {

            if (stack.isEmpty()) {
                stack.add(current);
                continue;
            }

            Integer peek = stack.peek();
            if (peek > current) {
                stack.add(current);
                continue;
            }

            //计算
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (pop >= current) {
                    //计算中间的
                    //todo

                }

            }


        }


        System.out.println("result:" + result);
        return result;
    }
}
