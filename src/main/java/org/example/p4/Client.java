package org.example.p4;

import java.rmi.registry.Registry;
import java.util.List;

import static java.rmi.registry.LocateRegistry.getRegistry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = getRegistry(null);

        StudentService stub = (StudentService) registry.lookup("StudentService");

        List<Student> list = stub.getStudents();

        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("Remote method invoked");
    }
}
