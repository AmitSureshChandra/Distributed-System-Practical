package org.example.p1;

import java.net.ServerSocket;

public class MultithreadedSocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);

            int counter = 0;

            System.out.println("Server Started ....");

            while (true) {
                counter++;
                new ServerThread(server.accept(), counter).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
