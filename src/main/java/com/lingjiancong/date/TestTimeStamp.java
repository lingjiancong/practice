package com.lingjiancong.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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
        LocalDateTime dateTime = LocalDateTime.parse("2016-08-22T07:51:57.09");

        LocalDateTime after = dateTime.plusDays(1);
        System.out.println(after);

        System.out.println(after.compareTo(LocalDateTime.now()));

        System.out.println(dateTime);

    }
}