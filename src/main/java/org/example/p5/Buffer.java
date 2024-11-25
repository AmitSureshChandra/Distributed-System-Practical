package org.example.p5;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final int maxSize;
    private final Queue<Integer> queue = new LinkedList<>();

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void produced(int value) {
        while (queue.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consumed() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify();
        return value;
    }
}
