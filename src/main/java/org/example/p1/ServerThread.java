package org.example.p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
    public ServerThread(Socket accept, int counter) {
        System.out.printf("Client %d connected\n", counter);

        try {
            DataInputStream inputStream = new DataInputStream(accept.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(accept.getOutputStream());

            String clientMsg = "", serverMsg = "";

            while (!clientMsg.equalsIgnoreCase("bye")) {
                clientMsg = inputStream.readUTF();
                System.out.printf("Client %d : %s\n", counter, clientMsg);

                serverMsg = "square of " + clientMsg + " is " + Math.pow(Double.parseDouble(clientMsg), 2);
                outputStream.writeUTF(serverMsg);
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.printf("Client %d disconnected\n", counter);
        }
    }
}
