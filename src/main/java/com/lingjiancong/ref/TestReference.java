package com.lingjiancong.ref;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * @author lingjiancong
 */
public class TestReference {

    @Test
    public void test() {
        WeakReference<String> wr = new WeakReference<String>(new String("Hello World!"));

        String s = wr.get();

        if (s == null) {
            System.out.println("garbage collect");
        } else {
            System.out.println("s = " + s);
        }
    }
}
