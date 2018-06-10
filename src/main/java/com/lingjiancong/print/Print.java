package com.lingjiancong.print;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/9/3.
 */
public abstract class Print {

    public static <K, V> void print(Map<K, V> m) {

        for (K k : m.keySet()) {
            System.out.println(k + " " + m.get(k));
        }
    }

    public static <K> void print(List<K> list) {
        for (K v : list) {
            System.out.print(v + " || ");
        }
        System.out.println();
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}
