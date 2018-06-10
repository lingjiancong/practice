package com.lingjiancong.container;

import org.junit.Test;

import java.util.BitSet;

/**
 * Created by lenovo on 2016/9/3.
 */
public class TestBitset {

    @Test
    public void testBitSet() {

        BitSet bitSet = new BitSet();

        bitSet.set(1);

        System.out.println(bitSet.length());

        System.out.println(bitSet.size());

        bitSet.set(2);
        bitSet.set(10);

        print(bitSet);
    }

    public void print(BitSet b) {
        System.out.println("bits: " + b);
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < b.size(); ++j) {
            sb.append(b.get(j) ? "1" : "0");
        }
        System.out.println("bit pattern: " + sb);
    }
}
