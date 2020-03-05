package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/17
 */
public class TestZone20200127 extends BaseTest {

    //1, 3, 2, 5, 7, 8, 0, 4

    public void bubbleSort() {
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

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

    }

    public void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            j++;
            arr[j] = key;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public int find(int target) {
        int low = 0;
        int high = arr.length - 1;
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

    //
    public int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid != 0 || arr[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    //
    //public int findLast(int[] arr, int target) {
    //}
    //
    //public int findFirstBiggerEqual(int[] arr, int target) {
    //    return -1;
    //}
    //
    //public int findLastLessEqual(int[] arr, int target) {
    //    return -1;
    //}

    @Test
    public void test() {
        //this.bubbleSort();
        //this.insertionSort();
        //this.selectionSort();
        //this.quickSort(this.arr, 0, arr.length - 1);
        int i = find(0);
        System.out.println(i);
    }

}
