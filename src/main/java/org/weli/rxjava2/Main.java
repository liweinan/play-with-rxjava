package org.weli.rxjava2;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) throws Exception {
        Scheduler scheduler = Schedulers.computation();
        Scheduler.Worker worker1 = scheduler.createWorker();
        Scheduler.Worker worker2 = scheduler.createWorker();

        worker1.schedule(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker1");
        });
        worker1.schedule(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker1 #2");
        });
        worker2.schedule(() -> {
            System.out.println("worker2");
        });

        Thread.sleep(4000);
    }
}
