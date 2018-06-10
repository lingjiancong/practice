package com.lingjiancong.exception;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lingjiancong
 */
public class ExceptionFinally {

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        ExceptionFinally ee = new ExceptionFinally();
        System.out.println(ee.inc());

        CopyOnWriteArrayList<String> a;
    }
}
