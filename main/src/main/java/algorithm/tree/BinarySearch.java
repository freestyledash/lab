package main.java.algorithm.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 普通二分查找
 * 查找第一个等于
 * 查找最后一个等于
 * 查找最后一个小于等于
 * 查找第一个大于等于
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/16
 */
public class BinarySearch {

    int[] arr;

    int result = 0;

    @BeforeEach
    public void init() {
        arr = new int[] {1, 3, 3, 4, 6, 7, 8, 8, 8, 9, 10, 11, 11, 14, 15};
        System.out.println("数组长度:" + arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    @AfterEach
    public void printResult() {
        System.out.println("  ");
        for (int i = 0; i <= result; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("  ");
        System.out.println(this.result);
    }

    /**
     * 找到就行
     *
     * @param target
     * @param arr
     * @return
     */
    public int find(int target, int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (true) {
            if (high == low) {
                if (arr[high] == target) {
                    return high;
                }
                break;
            }
            int middle = low + ((high - low) >> 1);
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] > target) {
                high = middle - 1;
                continue;
            }
            if (arr[middle] < target) {
                low = middle + 1;
                continue;
            }

        }
        //没有找到，返回-1
        return -1;
    }

    @Test
    public void testFind() {
        result = this.find(15, arr);
    }

    /**
     * 找到第一个
     *
     * @param target
     * @param arr
     * @return
     */
    public int findFirst(int target, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (arr[middle] > target) {
                high = middle - 1;
            } else if (arr[middle] < target) {
                low = middle + 1;
            } else {
                if (middle == 0 || arr[middle] - 1 != target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testFindFirst() {
        result = this.findFirst(8, this.arr);
    }

    public int findLast(int target, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] > target) {
                high = middle - 1;
            } else if (arr[middle] < target) {
                low = middle + 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] != target) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testFindLast() {
        result = this.findLast(8, this.arr);
    }

    /**
     * 找到第一个大于等于某个值的
     *
     * @param target
     * @param arr
     * @return
     */
    public int findFirstBiggerEqual(int target, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testFindFirstBiggerEqual() {
        result = this.findFirstBiggerEqual(3, this.arr);
    }

    /**
     * 找到第一个小于某个值的
     *
     * @param target
     * @param arr
     * @return
     */
    public int findLastLessEqual(int target, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }

        }
        return -1;
    }

    @Test
    public void testFindFirstLessEqual() {
        result = this.findLastLessEqual(8, this.arr);
    }

}
