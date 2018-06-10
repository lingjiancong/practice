package com.lingjiancong.logger;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by lenovo on 2016/8/31.
 */
public class MyLogger {

    @Test
    public void testLogger() {
        Logger logger = Logger.getLogger(MyLogger.class);

        logger.info("Hello Logger!");


        Logger daoLog = Logger.getLogger("daoLog");
        daoLog.info("Hello DaoLogger!");

    }
}
