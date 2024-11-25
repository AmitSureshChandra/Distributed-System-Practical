package org.example.p3;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends HelloImpl {

    public Server() {}

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        HelloImpl hello = new HelloImpl();

        // export the remote object to make it available to receive incoming calls
        Hello stub = (Hello) UnicastRemoteObject.exportObject(hello, 0);

        // bind the remote object's stub in the registry
        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("Hello", stub);

        System.out.print("Server is ready\n");
    }
}
