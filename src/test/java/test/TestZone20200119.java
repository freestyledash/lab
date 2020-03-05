package test;

import java.math.BigDecimal;
import java.util.BitSet;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/17
 */
public class TestZone20200119 {

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            //出错点：
            arr[j + 1] = key;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                if (j != i) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }

    //binary search
    public int find(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        //今天的错误
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int findFirst(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findLast(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid >= arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findFirstBiggerEqual(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid > 0 && arr[mid - 1] >= target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    ////出现问题
    public int findLastLessEqual(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid - 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        //int[] ints = new int[] {4, 4, 7, 1, 3, 2};

        //this.bubbleSort(ints);
        //this.insertionSort(ints);
        //this.selectSort(ints);
        //this.quickSort(ints, 0, ints.length - 1);
        //
        //for (int i : ints) {
        //    System.out.print(i + " ");
        //}

        int[] ints2 = new int[] {1, 2, 2, 3, 3, 4};
        //int i1 = find(ints2, 4);
        //int i1 = findFirst(ints2, 3);
        //int i1 = findLast(ints2, 3);
        //int i1 = findFirstBiggerEqual(ints2, 5);
        int i1 = findLastLessEqual(ints2, 2);
        System.out.println(i1);
    }

}
