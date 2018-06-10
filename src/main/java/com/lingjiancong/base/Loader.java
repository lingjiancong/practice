package com.lingjiancong.base;

import org.junit.Test;

/**
 * @author lingjiancong
 */
public class Loader {

    @Test
    public void testClass() {
        Class clz = Loader.class;

        ClassLoader loader = clz.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }


    }
}
