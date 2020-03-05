package com.lingjiancong.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by lenovo on 2016/8/23.
 */
public class TestTimeStamp {

    @Test
    public void testConstructor() {


        Timestamp timestamp = Timestamp.valueOf("2016-08-22 11:51:57");

        System.out.println(timestamp);

        long time = timestamp.getTime();

        System.out.println(timestamp.toLocalDateTime());

        System.out.println(new Date(time));
    }


    @Test
    public void testJava8Datetime() {

        Timestamp timestamp = Timestamp.valueOf("2016-08-22 07:51:57");
        LocalDateTime dateTime = LocalDateTime.parse("2018-12-01T00:00:00");
        System.out.println(dateTime.atZone(ZoneOffset.systemDefault()).toEpochSecond());

        Date date = new Date(118, 11, 1);
        System.out.println(date.getTime());

        System.out.println(dateTime);
        System.out.println(date);

        Object object = new Object();

        AtomicReference atomicReference;

        AtomicStampedReference atomicStampedReference;

    }
}