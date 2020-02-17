package feature.concurrency;

/**
 * 1114. Print in Order
 * https://leetcode.com/problems/print-in-order/
 * easy
 *
 * 1.使用自带的锁和wait，notify，notify all 解决问题
 * 2.使用juc工具解决问题
 * 3.并发解决问题，不使用同步机制
 *
 * @author zhangyanqi
 * @since 1.0 2019-12-18
 */
public class PrintInOrder {

    public PrintInOrder() {

    }

    private static final Object lock = new Object();
    private volatile int condition = 0;


    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
//         printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            condition++;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (condition != 1) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                lock.wait();
            }
            printSecond.run();
            condition++;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (condition != 2) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
