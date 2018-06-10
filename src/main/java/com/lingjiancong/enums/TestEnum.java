package com.lingjiancong.enums;

import java.math.RoundingMode;

/**
 * Created by lenovo on 2016/9/4.
 */

enum Numbers {
    ONE,
    TWO,
    THREE
}

public class TestEnum {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (Numbers n : Numbers.values()) {
            System.out.print(n + "  ");
            System.out.print("name: " + n.name());
            System.out.println(" ordinal: " + n.ordinal());
        }

        RoundingMode roundingMode = null;


        System.out.println(Numbers.valueOf("ONE"));


        Class<?> clz = Class.forName(Numbers.ONE.getClass().getName());
        Object object = clz.newInstance();
        System.out.println(object);
        ClassLoader classLoader;
    }
}
