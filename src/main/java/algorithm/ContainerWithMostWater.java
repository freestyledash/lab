package algorithm;

/**
 * 11. Container With Most Water
 * Medium
 * <p>
 * 思路：
 * 两个指针，矮的那个往中间逼近
 * https://zhuanlan.zhihu.com/p/33737430
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/12/25
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int result = 0;
        for (int index = 0; index < height.length - 1; index++) {
            int currentHeight = height[index];
            for (int leftIndex = index + 1; leftIndex < height.length; leftIndex++) {
                int width = leftIndex - index;
                int realHeight = Math.min(currentHeight, height[leftIndex]);
                int area = width * realHeight;
                if (area > result) {
                    result = area;
                }
            }
        }
        return result;
    }


    public int maxArea_(int[] x) {
        int left = 0;
        int right = x.length - 1;
        int maxArea = 0;
        while (right != left) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(x[left], x[right]));
            //谁短，谁不要
            if (x[left] <= x[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] input2 = {1, 1};
        int i = containerWithMostWater.maxArea_(input);
        System.out.println(i);
    }

}
