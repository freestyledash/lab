package algorithm.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Description
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

    int partition(int array[], int low, int high) {
        //int pivot = array[high];
        //// 记录下接下来要被替换的位置
        //// index of smaller element
        //int i = (low - 1);
        ////?
        //for (int j = low; j < high; j++) {
        //    // If current element is smaller than the pivot
        //    if (array[j] < pivot) {
        //        i++;
        //
        //        // swap arr[i] and arr[j]
        //        int temp = array[i];
        //        array[i] = array[j];
        //        array[j] = temp;
        //    }
        //}
        //// 将pivot从末尾搬到中间的位置
        //// swap arr[i+1] and arr[high] (or pivot)
        //int temp = array[i + 1];
        //array[i + 1] = array[high];
        //array[high] = temp;
        //
        //return i + 1;

        int pivot = array[high];
        int i = low - 1;
        for (int j = 0; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    //quick sort end

    @Test
    public void testQuickSort() {
        quickSort(this.toSort, 0, toSort.length - 1);
    }

    //merge sort begin
    void mergeSort(int[] arrays) {

    }

    @Test
    public void testMergeSort(int[] arrays) {

    }

    int[] heapSort(int[] array) {
        return null;
    }

    @Test
    void testHeapSort(int[] arrays) {

    }

    int[] bucketSort(int[] array) {
        return null;
    }

    @Test
    void testBucketSort(int[] arrays) {

    }

}
