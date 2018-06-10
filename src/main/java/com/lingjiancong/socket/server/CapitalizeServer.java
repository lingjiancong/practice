package com.lingjiancong.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ling on 2016/9/6.
 */
public class CapitalizeServer {


    public static void main(String[] args) throws IOException {
        int clientNumber = 0;

        String serverAddress = "127.0.0.1";
        ServerSocket serverSocket = new ServerSocket(9090);
        try {
            while (true) {
                new Capitalizer(serverSocket.accept(), clientNumber++).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Capitalizer extends Thread {
        private Socket socket;
        private int clientNumber;

        public Capitalizer(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
        }

        public void run() {
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String input = bf.readLine();
                    print(input);
                    if (input == null || ".".equals(input)) {
                        break;
                    }
                    pw.println(input.toUpperCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void print(String message) {
        System.out.println(message);
    }


}
