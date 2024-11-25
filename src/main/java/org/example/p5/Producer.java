package org.example.p5;

public class Producer implements Runnable{
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int val = 0;

        try {
            while (true) {
                buffer.produced(val++);
                Thread.sleep(1000); // simulate time taken to produce
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
