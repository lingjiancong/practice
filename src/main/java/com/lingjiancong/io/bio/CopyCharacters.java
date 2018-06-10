package com.lingjiancong.io.bio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lingjiancong
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("write_log4j.properties"));
            outputStream = new FileWriter("characteroutput.txt");
            int count = 0;

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
                count++;
            }
            System.out.println("count = " + count);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
