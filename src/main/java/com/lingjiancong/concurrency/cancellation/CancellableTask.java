package com.lingjiancong.concurrency.cancellation;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * @author lingjiancong
 */
public interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
