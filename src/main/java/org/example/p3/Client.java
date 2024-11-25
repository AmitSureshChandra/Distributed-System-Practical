package org.example.p3;

import java.rmi.registry.Registry;

import static java.rmi.registry.LocateRegistry.getRegistry;

public class Client {
    public Client() {}

    public static void main(String[] args) throws Exception {
        Registry registry = getRegistry(null);

        Hello stub = (Hello) registry.lookup("Hello");

        stub.printMsg("Hello from client");

        System.out.println("Remote method invoked");
    }
}
