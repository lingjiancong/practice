package com.lingjiancong.jvm.chapter1;

/**
 * VM Args: -Xss128k
 * @author lingjiancong
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF ocm = new JavaVMStackSOF();
        try {
            ocm.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length:" + ocm.stackLength);
            throw e;
        }
    }
}
