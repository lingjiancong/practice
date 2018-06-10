package com.lingjiancong.rmi.client;


import java.io.Serializable;
import java.math.BigDecimal;

import com.lingjiancong.rmi.compute.Task;

/**
 * @author lingjiancong
 */
public class Pi implements Task<BigDecimal>, Serializable {

    @Override
    public BigDecimal execute() {
        return new BigDecimal(100);
    }
}
