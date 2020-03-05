package com.lingjiancong.base;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

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

    @Test
    public void testListEqual() {

        List<String>  a = new ArrayList<>();
        a.addAll(Arrays.asList("a", "c", "b"));

        List<String>  b = new ArrayList<>();
        b.addAll(Arrays.asList("b", "a", "c"));

        System.out.println(a.equals(b));

        Collections.sort(a);
        Collections.sort(b);

        System.out.println(a.equals(b));


    }
}
