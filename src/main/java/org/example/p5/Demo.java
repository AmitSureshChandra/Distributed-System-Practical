package org.example.p5;

public class Demo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
