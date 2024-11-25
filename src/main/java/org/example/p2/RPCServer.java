package org.example.p2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class RPCServer {

    DatagramSocket ds;
    DatagramPacket dp;
    String str, methodName, result;
    int val1, val2;

    public RPCServer() {
        try {
            ds = new DatagramSocket(1200);
            byte[] b = new byte[4096];
            while (true) {
                dp = new DatagramPacket(b, b.length);
                ds.receive(dp);
                str = new String(dp.getData(), 0, dp.getLength());
                if(str.equalsIgnoreCase("q")) {
                    System.exit(0);
                }
                StringTokenizer st = new StringTokenizer(str, " ");
                int i = 0;
                while (st.hasMoreTokens()) {
                    methodName = st.nextToken();
                    val1 = Integer.parseInt(st.nextToken());
                    val2 = Integer.parseInt(st.nextToken());
                }
                result = getResult(methodName);
                byte[] b1 = result.getBytes();
                DatagramSocket ds1 = new DatagramSocket();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1300);
                System.out.println("Result : " + result);
                ds1.send(dp1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getResult(String methodName) {
        switch (methodName) {
            case "add":
                return String.valueOf(val1 + val2);
            case "sub":
                return String.valueOf(val1 - val2);
            case "mul":
                return String.valueOf(val1 * val2);
            case "div":
                return String.valueOf(val1 / val2);
            default:
                return  "Invalid method";
        }
    }

    public static void main(String[] args) {
        new RPCServer();
    }
}
