package com.lingjiancong.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lingjiancong
 */
public class Preloader {

    private final FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return null;
        }
    });

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();

        Set<Integer> set = new HashSet<Integer>();
        set.add(2);
    }

    public Integer get() throws InterruptedException {
        Integer i = null;
        try {
            i = futureTask.get();
        } catch (ExecutionException e) {
            Throwable throwable = e.getCause();
            if (throwable instanceof NullPointerException) {
                ;
            } else {
                throw launderThrowable(e);
            }
        }
        return i;
    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error)t;
        } else {
            throw new IllegalStateException("Not checked", t);
        }
    }
}
