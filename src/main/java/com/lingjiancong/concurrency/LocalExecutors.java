package com.lingjiancong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lingjiancong
 */
public class LocalExecutors {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main begin!! ");

        runTask();

        System.out.println("sleep 1s");

        TimeUnit.MICROSECONDS.sleep(1);

        runTask();
        System.out.println("sleep 2s");
        TimeUnit.MICROSECONDS.sleep(1);

        System.out.println("main exit");

    }

    public static void runTask() {
        Task task = new Task(new Run());
        task.start();
    }

    public static void test() {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        exec.submit(new Runnable() {
            @Override
            public void run() {
               ;
            }
        });
    }
}


class Task {
    Runnable runnable;
    ExecutorService exec;

    public Task(Runnable runnable) {
        this.runnable = runnable;
        exec = Executors.newFixedThreadPool(1);
    }

    public void start() {
        exec.submit(runnable);
    }
}

class Run implements Runnable {

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println(Thread.currentThread() + " " + " keep alive!");
        }
    }
}
