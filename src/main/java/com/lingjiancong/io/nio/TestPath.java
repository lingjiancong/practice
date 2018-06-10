package com.lingjiancong.io.nio;

import static java.nio.file.StandardCopyOption.*;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lingjiancong
 */
public class TestPath {

    @Test
    public void test() throws IOException {
        Path path = Paths.get("write_log4j.properties");
        System.out.println(path);

        System.out.println(path.toAbsolutePath());

        for (Path p : path.toAbsolutePath()) {
            System.out.println(p);
        }

        // This method throws an exception if the file does not exist or cannot be accessed
        System.out.println(path.toRealPath());
    }

    @Test
    public void testCopy() throws IOException {
        CopyOption[] options = new CopyOption[]{REPLACE_EXISTING};
        Path p1 = Paths.get("write_log4j.properties");
        Path p2 = Paths.get("write_log4j.path");

        // UnixCopyFile method: native void transfer()
        Files.copy(p1, p2, options);

        FileUtils.copyFile(p1.toFile(), p2.toFile());


    }
}
