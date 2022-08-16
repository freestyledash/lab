package test.java.test;

import org.junit.jupiter.api.Test;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/17
 */
public class TestZone20200128 extends BaseTest {

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

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int midIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[midIdx]) {
                    midIdx = j;
                }
            }
            int temp = arr[midIdx];
            arr[midIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (high > low) {
            int partition = partition(arr, low, high);
            quickSort(arr, partition + 1, high);
            quickSort(arr, low, partition - 1);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }

    int[] sortedArr = new int[] {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9};

    public int find(int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (sortedArr[mid] > target) {
                high = mid - 1;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int findFirst(int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (sortedArr[mid] > target) {
                high = mid - 1;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || sortedArr[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findLast(int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (sortedArr[mid] > target) {
                high = mid - 1;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == sortedArr.length - 1 || sortedArr[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int findFirstBiggerEqual(int target) {
        int high = sortedArr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || sortedArr[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findLastLessEqual(int target) {
        int high = sortedArr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (sortedArr[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == sortedArr.length - 1 || sortedArr[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //int[] sortedArr = new int[] {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9};

    @Test
    public void test() {
        //this.bubbleSort();
        //this.insertionSort();
        //this.selectionSort();
        //this.quickSort(this.arr, 0, arr.length - 1);

        //int i = find(9);
        //int i = findFirst(4);
        //int i = findLast(4);
        //int i = findFirstBiggerEqual(4);
        int i = findLastLessEqual(4);

        System.out.println(i);
    }

}
