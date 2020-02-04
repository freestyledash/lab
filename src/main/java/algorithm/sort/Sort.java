package algorithm.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * this is very really extremely vital critical important
 * pull out all step to remember them!
 *
 * small ---> big
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/14
 */
public class Sort {

    int[] toSort;

    @BeforeEach
    public void init() {
        toSort = new int[] {2, 10, 20, 9, 1, 3, 3, 7};
    }

    @AfterEach
    public void printResult() {
        for (int i : toSort) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     * 基于比较
     * 稳定
     * 原地排序
     * 最差时间复杂度 n^2
     * 最佳时间复杂度 n
     * 平均时间复杂度 n^2
     *
     * @param array
     */
    void bubbleSort(int[] array) {
        //两次循环的设计很巧妙
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void testBubbleSort() {
        bubbleSort(this.toSort);
    }

    /**
     * 插入排序
     * 稳定
     * 基于比较
     * 原地排序
     * 最差时间复杂度 n^2
     * 最好时间复杂度 n
     * 平均时间复杂度 n^2
     *
     * 相比冒泡排序，不必每次都创建新的变量
     *
     * @param array
     */
    void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Test
    public void testInsertionSort() {
        insertionSort(this.toSort);
    }

    /**
     * 选择排序
     * 基于比较
     * 不稳定
     * 原地排序
     * 最差时间复杂度 n^2
     * 最好时间复杂度 n
     * 平均时间复杂度 n^2
     *
     * @param array
     */
    void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    @Test
    public void testSelectionSort() {
        selectionSort(this.toSort);
    }

    // quick sort begin

    /**
     * 快速排序
     * 基于比较
     * 不稳定
     * 原地排序
     *
     *
     * 写出递归公式，终止条件
     *
     * @param array
     * @param low   index of low
     * @param high  index of high
     */
    void quickSort(int[] array, int low, int high) {
        if (high > low) {
            int partition = partition(array, low, high);
            quickSort(array, low, partition - 1);
            quickSort(array, partition + 1, high);
        }
    }

    int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[high] = array[i + 1];
        array[i + 1] = pivot;
        return i + 1;
    }
    //quick sort end

    @Test
    public void testQuickSort() {
        quickSort(this.toSort, 0, toSort.length - 1);
    }

    //merge sort begin

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge_(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) { L[i] = arr[l + i]; }
        for (int j = 0; j < n2; ++j) { R[j] = arr[m + 1 + j]; }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge_(arr, l, m, r);
        }
    }

    @Test
    public void testMergeSort(int[] arrays) {
        this.mergeSort(this.toSort, 0, arrays.length - 1);
    }

    void heapSort(int[] array) {
    }

    @Test
    void testHeapSort(int[] arrays) {

    }

    void bucketSort(int[] array) {
    }

    @Test
    void testBucketSort(int[] arrays) {

    }

}
