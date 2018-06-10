package com.lingjiancong.io.bio;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lingjiancong
 */
public class ReadWrite {

    static private String WRITE_PREFIX = "write_";

    @Test
    public void copy() {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String path = "classpath:log4j.properties";
        Resource resource = resolver.getResource(path);

        InputStream is = null;
        try {
            is = resource.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("File: " + path + "doesn't exist!");
        }

        String outPath = WRITE_PREFIX + resource.getFilename();
        System.out.println(outPath);
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(outPath));
            byte[] bytes = new byte[100];
            int len = 0;

            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Output file cannot create!");
        } catch (IOException e) {
            throw new RuntimeException("Copy exception!");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Test
    public void copyByCommonIO() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String path = "classpath:log4j.properties";
        Resource resource = resolver.getResource(path);

        File input = null;
        try {
            input = resource.getFile();
        } catch (IOException e) {
            throw new RuntimeException("File: " + path + "doesn't exist!");
        }
        String outPath = "COMMON_IO" + resource.getFilename();
        FileUtils.copyFile(input, new File(outPath));
    }
}
