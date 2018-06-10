package com.lingjiancong.concurrency.cache;

/**
 * @author lingjiancong
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
