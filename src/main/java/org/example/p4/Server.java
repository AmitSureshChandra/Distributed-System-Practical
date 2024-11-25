package org.example.p4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        StudentServiceImpl studentService = new StudentServiceImpl();

        StudentService stub = (StudentService) UnicastRemoteObject.exportObject(studentService, 0);

        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("StudentService", stub);

        System.out.print("server is ready\n");
    }
}
