package com.lingjiancong.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lingjiancong
 */
public class ForEachTest {

    @Test
    public void modifyTest() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            System.out.println(item);
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        HashMap<String, Integer> map;
        Executors executors;
        DelayQueue delayQueue;
        CountDownLatch latch;

        Random random = ThreadLocalRandom.current();

    }
}
