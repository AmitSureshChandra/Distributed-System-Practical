package org.example.p5;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
       try {
           while (true) {
               buffer.consumed();
               Thread.sleep(1000); // simulate time taken to consume
           }
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
