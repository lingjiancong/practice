package com.lingjiancong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程退出的方式，检查wait
 *
 * @author lingjiancong
 */
public class ThreadWait {

    static class Wait implements Runnable {

        @Override
        public void run() {
            // cool
            try {
                while (!Thread.interrupted()) {
                    for(int i = 0; i < 100000; ++i) {
                        int x = 11 + 12 * 12;
                    }
                    System.out.println(Thread.currentThread() + " ");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Exited by exception!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Wait());

        TimeUnit.SECONDS.sleep(10);

        exec.shutdownNow();

        ReentrantLock lock;

    }


}
