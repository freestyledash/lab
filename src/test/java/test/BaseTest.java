package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/27
 */
public class BaseTest {

    protected int[] arr;

    @BeforeEach
    public void init() {
        System.out.println("begin");
        this.arr = new int[] {1, 3, 2, 5, 7, 8, 0, 4};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    @AfterEach
    public void printResult() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("end");
    }

}
