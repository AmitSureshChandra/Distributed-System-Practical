package org.example.p3;

import java.rmi.Remote;

public interface Hello extends Remote {
    void printMsg(String msg) throws Exception;
}
