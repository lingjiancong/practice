package com.lingjiancong.compare;

import org.junit.Test;

import java.text.Collator;

/**
 * @author lingjiancong
 */
public class Trivial {

    @Test
    public void collator() {
        Collator collator = Collator.getInstance();

        String s1 = "01", s2 = "02";
        System.out.println(collator.compare(s1, s2));
    }
}
