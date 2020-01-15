package algorithm.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Description
 * this is very really extremely vital critical important
 * pull out all step to remember them!
 *
 * small --- big
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
            //需要进行比较的值
            int key = array[i];
            //开始进行比较的起点
            int j = i - 1;
            //需要比较的值之前的都是经过排序的，依次比较，如果之前的大，就往前走一步
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
        int n = array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
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
     * @param low
     * @param high
     */
    void quickSort(int array[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        // index of smaller element
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    //quick sort end

    //merge sort begin
    void mergeSort(int[] arrays) {

    }

    int[] heapSort(int[] array) {
        return null;
    }

    int[] bucketSort(int[] array) {
        return null;
    }

}
