package org.example.p3;

public class HelloImpl implements Hello {
    @Override
    public void printMsg(String msg) {
        System.out.println("Client : " + msg);
    }
}
