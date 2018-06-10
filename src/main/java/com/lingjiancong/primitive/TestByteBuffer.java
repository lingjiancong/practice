package com.lingjiancong.primitive;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author lingjiancong
 */
public class TestByteBuffer {


    /**
     * print big-endian and little-endian bit
     */
    @Test
    public void printEndian() {

        printEndian(12, ByteOrder.BIG_ENDIAN);
        printEndian(12, ByteOrder.LITTLE_ENDIAN);

    }

    public void printEndian(int num, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.order(byteOrder);
        byte[] bytes = byteBuffer.putInt(num).array();
        for (byte b : bytes) {
            printByteToBinary(b);
            System.out.print(", ");
        }
        System.out.println();
    }

    public void printByteToBinary(byte b) {
        String s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        System.out.print(s);
    }
}
