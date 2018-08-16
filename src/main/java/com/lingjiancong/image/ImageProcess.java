package com.lingjiancong.image;


import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

/**
 * @author lingjiancong
 * @since 2018-07-13
 */
public class ImageProcess {


    public static enum EnumTest {
        Process;
    }

    public static void main(String[] args) {
        EnumTest enumTest = EnumTest.Process;
        System.out.println(enumTest.toString());
    }

    @Test
    public void testSplitter() {
        String field = null;
        List<String> fields = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(field);
        System.out.println(fields);
    }
}
