package com.lingjiancong.exception;

import org.junit.Test;

/**
 * Created by lenovo on 2016/8/22.
 */


class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void catchException() throws Exception {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } catch (Exception e) {
                lm.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            System.out.println("finally block!");
        }
    }


}
