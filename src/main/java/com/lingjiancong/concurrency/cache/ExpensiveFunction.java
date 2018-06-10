package com.lingjiancong.concurrency.cache;

import java.math.BigInteger;

/**
 * @author lingjiancong
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) {
        // after deep thought...
        return new BigInteger(arg);
    }
}
