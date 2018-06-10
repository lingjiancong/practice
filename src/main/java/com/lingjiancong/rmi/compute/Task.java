package com.lingjiancong.rmi.compute;

/**
 * @author lingjiancong
 */
public interface Task<T> {
    T execute();
}
