package org.example.p1;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg = "", serverMsg = "";

            while (!clientMsg.equalsIgnoreCase("bye")) {
                System.out.print("Enter the number : ");
                clientMsg = br.readLine();
                out.writeUTF(clientMsg);
                out.flush();

                serverMsg = in.readUTF();
                System.out.println("Server : " + serverMsg);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Client disconnected");
        }
    }
}
