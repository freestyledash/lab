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
        toSort = new int[] {9, 1, 3, 3, 7};
    }

    @AfterEach
    public void printResult() {
        for (int i : toSort) {
            System.out.print(i + " ");
        }
    }

    void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    /**
                     * 这里要使用一个中间变量 有性能消耗
                     */
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    void insertionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int k = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > k) {
                //往前移动一位
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = k;
        }
    }

    void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                min = Math.min(array[j], min);
            }
            array[i] = min;
        }
    }

    int[] quickSort(int[] array) {
        return null;
    }

    int[] heapSort(int[] array) {
        return null;
    }

    int[] bucketSort(int[] array) {
        return null;
    }

    @Test
    public void testBubbleSort() {
        bubbleSort(this.toSort);
    }

    @Test
    public void testInsertionSort() {
        insertionSort(this.toSort);
    }

    @Test
    public void testSelectionSort() {
        selectionSort(this.toSort);
    }

}
