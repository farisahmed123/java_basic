package com.example.threads;
//package com.example.Array;
import java.util.concurrent.*;
//
public class Twothreads {

    public static void main(String[] args) throws InterruptedException {
        // Create a virtual thread-based executor (Java 21+)
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // Shared CompletableFuture to hold the array
        CompletableFuture<int[]> arrayin = new CompletableFuture<>();

        // Submit task to initialize array
        executor.submit(() -> {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("Thread 1 (Initialized Array): " + Thread.currentThread());
            arrayin.complete(arr);
        });
        System.out.println("asdas");
        // Submit task to calculate sum
        executor.submit(() -> {
            try {
                int[] arr = arrayin.get();
                int sum = 0;
                for (int a : arr) {
                    sum += a;
                }
                System.out.println("Thread 2 (Sum): " + sum + " - " + Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("After Thread 2");
        // Submit task to calculate multiplication
        executor.submit(() -> {
            try {
                int[] arr = arrayin.get();
                int mul = 1;
                for (int i : arr) {
                    mul *= i;
                }
                System.out.println("Thread 3 (Product): " + mul + " - " + Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("After Thread 3");
        // Give tasks time to complete (or you could use futures + await them)
        Thread.sleep(500);

        // Shut down the executor
        executor.shutdown();
    }
}
