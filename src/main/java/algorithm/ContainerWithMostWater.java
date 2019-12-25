package algorithm;

/**
 * leetCode 11. Container With Most Water
 * Medium
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

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] input2 = {1, 1};
        int i = containerWithMostWater.maxArea(input2);
        System.out.println(i);
    }

}
