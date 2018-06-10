package com.lingjiancong.container;

import org.junit.Test;

import java.util.*;

import static com.lingjiancong.print.Print.print;

/**
 * Created by lenovo on 2016/9/3.
 */
public class TestEntrySet {

    @Test
    public void testMap() {
        Map<String, String> maps = new HashMap<>();

        maps.put("k1", "v1");
        maps.put("k2", "v2");
        maps.put("k3", "v3");

        for (Map.Entry<String, String> entry : maps.entrySet()) {
            entry.setValue("vvv");
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }

        print(maps);

    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>(Arrays.asList("one two three".split(" ")));

        ListIterator<String> listIterator = list.listIterator(1);

        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " || ");
        }
        System.out.println();

        listIterator = list.listIterator(1);

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " || ");
        }
        System.out.println();

    }

    @Test
    public void testCollectionSwap() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        Collections.swap(list, 1, 2);

        print(list);
    }


}
