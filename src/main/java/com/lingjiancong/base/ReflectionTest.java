package com.lingjiancong.base;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author lingjiancong
 * @since 2018-06-20
 */
public class ReflectionTest {

    public class Inner {
        public Long value;
    }

    @Test
    public void setLongTest() throws NoSuchFieldException, IllegalAccessException {
        Class clazz = Inner.class;
        Field field = clazz.getField("value");

        Inner inner = new Inner();
        field.set(inner, 10L);

        System.out.println(inner.value);
    }

}
