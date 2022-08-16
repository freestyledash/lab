package main.java.feature.reference;

import java.lang.ref.*;

/**
 * 引用
 *
 * @author zhangyanqi
 * @since 1.0 2019-02-08
 */
public class Main {

    /**
     * gc when lack of Mem
     */
    public static void softReference() {
        Object o = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference(o);
        o = null;
        System.gc();
        Object o1 = objectSoftReference.get();
        System.out.println(o1);  //not null
    }

    /**
     * not prevent gc
     */
    public static void weakReference() {
        Object o = new Object();
        WeakReference weakReference = new WeakReference(o);
        o = null;
        System.gc();
        Object o1 = weakReference.get();
        System.out.println(o1);  //null
    }


    /**
     * didn't influence left cycle of gc ,only  get notification when gc
     */
    public static void phantomReference() {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object o = new Object();
        PhantomReference phantomReference = new PhantomReference(o, referenceQueue);
        Object o1 = phantomReference.get();
        //!! must null whenever circumstance
        System.out.println(o1);
        //make sure o must be gc
        o = null;
        System.gc();
        try {
            Reference remove = referenceQueue.remove();// block until
            System.out.println(remove);  //after gc,is not null;before gc ,is null
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phantomReference();
    }
}
