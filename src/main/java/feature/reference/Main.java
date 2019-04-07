package feature.reference;

import java.lang.ref.*;

/**
 * @author zhangyanqi
 * @since 1.0 2019-02-08
 */
public class Main {


    public static void weakReference() {
        Object o = new Object();
        WeakReference weakReference = new WeakReference(o);
        o = null;
        System.gc();
        Object o1 = weakReference.get();
        System.out.println(o1);  //null
    }

    public static void softReference() {
        Object o = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference(o);
        o = null;
        System.gc();
        Object o1 = objectSoftReference.get();
        System.out.println(o1);  //not null
    }

    public static void phantomReference() {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object o = new Object();
        PhantomReference<Object> objectSoftReference = new PhantomReference(o, referenceQueue);
        Object o1 = objectSoftReference.get();
        System.out.println(o1);  //must null whenever circumstance
        o = null;
        System.gc();
        try {
            Reference remove = referenceQueue.remove();
            System.out.println(remove);  //after gc,is not null;before gc ,is null
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        softReference();
        phantomReference();
    }
}
