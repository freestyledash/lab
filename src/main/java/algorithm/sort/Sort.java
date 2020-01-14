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

    /**
     * 冒泡排序
     *
     * @param array
     */
    void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    //此处每次会多一个temp
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
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
            j++;
            array[j] = key;
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
