package com.lingjiancong.base;

import java.lang.reflect.Field;
import org.junit.Test;

/**
 * @author lingjiancong
 */
public class TestSwapInteger {

    public static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        int tmp = b.intValue();
        value.set(b, a);
        value.set(a, tmp);

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        System.out.println("a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("a = " + a + " b = " + b);
    }

    @Test
    public void testEqual() {
        Long value = new Long(0);
        boolean res = (value == 0);
    }
}
