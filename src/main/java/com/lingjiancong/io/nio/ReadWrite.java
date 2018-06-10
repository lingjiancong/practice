package com.lingjiancong.io.nio;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lingjiancong
 */
public class ReadWrite {

    static private String PREFIX = "CHANNEL_";
    static private int BSIZE = 1024;

    @Test
    public void copy() {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String path = "classpath:log4j.properties";
        Resource resource = resolver.getResource(path);

        String urlPath = null;
        try {
            urlPath = resource.getFile().getCanonicalPath().toString();
        } catch (IOException e) {
            throw new RuntimeException("File: " + path + "doesn't exist!");
        }

        String outPath = PREFIX + resource.getFilename();

        FileChannel in = null, out = null;
        try {
            System.out.println(urlPath);
            in = new FileInputStream(urlPath).getChannel();
            out = new FileOutputStream(outPath).getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found!");
        } catch (IOException e) {
            throw new RuntimeException("read write error!");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        InputStream is = null;
    }

    @Test
    public void transfer() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String path = "classpath:log4j.properties";
        Resource resource = resolver.getResource(path);

        String urlPath = null;
        urlPath = resource.getFile().getCanonicalPath().toString();

        String outPath = PREFIX + resource.getFilename();

        FileChannel in = null, out = null;
        System.out.println(urlPath);
        in = new FileInputStream(urlPath).getChannel();
        out = new FileOutputStream(outPath).getChannel();

        in.transferTo(0, in.size(), out);
    }

}
