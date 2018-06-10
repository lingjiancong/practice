package com.lingjiancong.jvm.chapter1;

/**
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * @author lingjiancong
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("Hello").append("world").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
