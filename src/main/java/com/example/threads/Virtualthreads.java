package com.example.threads;

public class Virtualthreads {
    public static void main(String[] args) throws InterruptedException {
        Thread vt = Thread.startVirtualThread(() -> {
            System.out.println("Running in: " + Thread.currentThread());
        });

        // Wait for the virtual thread to finish
        vt.join();
    }
}


