package org.example.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RPCClient {
    public RPCClient() {
        try {
            DatagramSocket ds = new DatagramSocket();
            DatagramSocket ds1 = new DatagramSocket(1300);
            System.out.println("\nRPC Client\n");
            System.out.println("Enter method name and parameter like add 3 4\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = br.readLine();
                if (str.equalsIgnoreCase("q")) {
                    System.exit(0);
                }

                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getLocalHost(), 1200);

                ds.send(dp);
                dp = new DatagramPacket(new byte[4096], 4096);

                ds1.receive(dp);

                str = new String(dp.getData(), 0, dp.getLength());
                System.out.printf("Result : %s\n", str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RPCClient();
    }
}
