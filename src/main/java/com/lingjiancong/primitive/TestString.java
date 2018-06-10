package com.lingjiancong.primitive;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author lingjiancong
 */
public class TestString {

    @Test
    public void testIntern() {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        String s4 = s3.intern();

        System.out.println(s1 == s2); // true
        System.out.println(s2 == s3); // false
        System.out.println(s2 == s4); // true
    }

    @Test
    public void testStringUtils() {
        System.out.println(StringUtils.isEmpty(""));
    }

    @Test
    public void testInteger() {
        Integer a1 = 10, b1 = 10;
        Integer a2 = 300, b2 = 300;
        Integer a3 = 1000, b3 = 1000;
        System.out.println(a1 == b1);
        System.out.println(a2 == b2);
        System.out.println(a3 == b3);

        Integer a = 123;
        System.out.println(a.toString());
    }

    @Test
    public void testValueOf() {
        Integer i1 = Integer.valueOf(2);
        Integer i2 = Integer.valueOf(2);
        System.out.println(i1 == i2);

        int i3 = 2;
        System.out.println(i2.equals(i3));

    }

    @Test
    public void testHashCode() {
        Integer i = 10;
        System.out.println(i.hashCode());

        String s = "abcdef";
        System.out.println(s.hashCode());

        Double d = 4.5;
        System.out.println(d.hashCode());

    }

    @Test
    public void testMap() {
        HashMap<String, String> maps = new HashMap<>();
        maps.put("a", "b");

        for (String k : maps.keySet()) {
            System.out.println(maps.get(k));
        }
    }

    @Test
    public void testTrim() {
        String s = " abcd ";
        System.out.println(s + "xx");
        System.out.println(s.trim() + "xx");
    }

    @Test
    public void testChatInt() {
        char c = ' ';
        System.out.println((int)c);

        String s = "";
        System.out.println();

    }

    @Test
    public void testIsWhiteSpace() {
        char c = ' ';
        System.out.println(Character.isWhitespace(c));

        /**
         * '\u0009' HORIZONTAL TABULATION
         * "\\u000A" LINE FEED
         * '\u000B' VERTICAL TABULATION
         * '\u000C' FORM FEED
         * "\\u000D" CARRIAGE RETURN
         * '\u001C' FILE SEPARATOR
         * '\u001D' GROUP SEPARATOR
         * '\u001E' RECORD SEPARATOR
         * '\u001F' UNIT SEPARATOR
         */

        char line = '\u0009' + 1;
        System.out.println( "\\u" + Integer.toHexString(line | 0x10000).substring(1) );


        char[] whiteSpaces = {'\u0009', '\u000B', '\u000C', '\u001C', '\u001D', '\u001E', '\u001F'};

        for (char character : whiteSpaces) {
            System.out.println("***" + character + "***" + (int)character);
            System.out.println();

        }
    }


}
