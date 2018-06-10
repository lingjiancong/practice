package com.lingjiancong.io.bio;

/**
 * @author lingjiancong
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("write_log4j.properties");
            out = new FileOutputStream("outagain.txt");
            int c;
            int count = 0;

            while ((c = in.read()) != -1) {
                out.write(c);
                count++;
            }

            System.out.println("count = " + count);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        InputStream ins = null;
    }
}
