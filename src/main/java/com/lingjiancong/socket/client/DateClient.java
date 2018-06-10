package com.lingjiancong.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author lingjiancong
 */
public class DateClient {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();

        System.out.println(answer);
    }
}
