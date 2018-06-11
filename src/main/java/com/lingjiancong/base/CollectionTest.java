package com.lingjiancong.base;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lingjiancong
 * @since 2018-06-11
 */
public class CollectionTest {

    @Test
    public void hashSetTest() {
        Set<Integer> set = new HashSet<>();
    }

    @Test
    public void mapTest() {
        Map<String, Integer> map = new HashMap<>(64);
        map.put("string", 1);

        Integer i = 10;
        System.out.println(i.hashCode());
    }
}
