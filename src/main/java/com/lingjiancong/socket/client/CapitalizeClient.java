package com.lingjiancong.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ling on 2016/9/6.
 */
public class CapitalizeClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9090);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                String s = scanner.nextLine();

                System.out.println("console echo: " + s);

                out.println(s);

                String response = in.readLine();

                System.out.println(response);
            }
        } finally {
            in.close();
            out.close();
        }
    }
}
