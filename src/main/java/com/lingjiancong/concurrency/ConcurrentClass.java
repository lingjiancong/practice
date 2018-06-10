package com.lingjiancong.concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lingjiancong
 */
public class ConcurrentClass {

    @Test
    public void testSynchronizedClass() {
        List<Integer> list = new ArrayList<>();
        Collections.synchronizedList(list);

        Map<String, String> map = new HashMap<>();
        Collections.synchronizedMap(map);
    }

    @Test
    public void testConcurrentClass() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.putIfAbsent("absent", "Hello World");
        map.put("none", "first");

        List<String> list = new CopyOnWriteArrayList<>();

        list.add("first");
        list.add("second");

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
        for (String ele : list) {
            System.out.println(ele);
        }
    }

    @Test
    public void testInt() {
        System.out.println(Integer.MAX_VALUE);
    }
}
