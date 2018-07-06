package com.lingjiancong.concurrency.baseclass;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author lingjiancong
 * @since 2018-06-28
 */
public class LockTest {

    Lock lock = new ReentrantLock();

    int value = 1;

    @Test
    public void lockTest() throws InterruptedException {

        ExecutorService service = new ThreadPoolExecutor(10, 10, 6000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    if (value == 1) {
                        TimeUnit.SECONDS.sleep(100);
                    } else {
                        TimeUnit.SECONDS.sleep(100);
                    }
                    value += 1;
                } catch (InterruptedException e) {
                    System.out.println(e);
                } finally {
                    lock.unlock();
                }
                Thread thread;
            }
        };

        IntStream.range(0, 10).forEach(x -> {
            service.execute(runnable);
        });

        service.shutdown();
        service.awaitTermination(100, TimeUnit.SECONDS);

        System.out.println(value);
    }

}
