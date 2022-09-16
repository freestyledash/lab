package feature.lamda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * just refer the doc of lamda
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/11/22
 */
public class Main {

    /*
    create steam

    operate

    collect/get result
     */


    public static void main(String[] args) throws Exception {

        testParaStream();


    }


    public static void testParaStream() throws Exception {

        Object o = forkJoinPool.submit(new Task()).get();
        for (Info info : q) {
            System.out.println(info.toString());
        }

    }

    public static Queue<Info> q = new LinkedList<>();

    public static class Info {
        public int id;
        public String name;

        public static Info create(int id, String name) {
            Info info = new Info();
            info.id = id;
            info.name = name;
            return info;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static synchronized void addQ(Info i) {
        q.add(i);
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            List<O> originList = new ArrayList<>();
            originList.add(O.create(1));
            originList.add(O.create(2));
            originList.add(O.create(3));
            originList.add(O.create(4));
            originList.add(O.create(5));
            originList.add(O.create(6));
            originList.add(O.create(7));
            originList.add(O.create(8));
            originList.add(O.create(9));
            originList.add(O.create(0));


            originList.parallelStream()
                    .forEach((o) -> {
                        addQ(Info.create(o.id, Thread.currentThread().getName()));
                    });
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    })
//                    .map((o) -> {
//                        addQ(Info.create(o.id, Thread.currentThread().getName()));
//                        return o;
//                    }).
//
//
//                    collect(Collectors.toList());
        }
    }

    public static class O {

        int id = 0;

        static O create(int id) {
            O o = new O();
            o.id = id;
            return o;
        }

    }


    public static ForkJoinPool forkJoinPool = new ForkJoinPool(3, new ForkJoinPool.ForkJoinWorkerThreadFactory() {

        AtomicLong atomicLong = new AtomicLong(0);

        @Override
        public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
            ForkJoinWorkerThread forkJoinWorkerThread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            forkJoinWorkerThread.setName("custom-forkJoinPool-" + atomicLong.incrementAndGet());
            return forkJoinWorkerThread;
        }
    }, null, false);

}
