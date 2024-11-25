package org.example.p4;

import java.rmi.Remote;
import java.util.List;

public interface StudentService extends Remote {
    List<Student> getStudents() throws Exception;
}
