package com.lingjiancong.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjiancong
 */
public class TestString {

    @Test
    public void testString() {
        String str = new StringBuilder("计算机").append("软件").toString();
        String str2 = "计算机软件";
        String str3 = str.intern();
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str2 == str3);

        String str4 = new String("string");
        String str5 = "string";
        System.out.println(str4 == str5);
        System.out.println(str5.intern() == str5);
    }

    @Test
    public void iterateRemoveTest() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }
}
