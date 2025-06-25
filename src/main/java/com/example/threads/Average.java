package com.example.threads;
import java.util.*;
public class Average {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(41) + 10;
        }
        double[] avg = new double[3];
        Thread[] threads = new Thread[3];
        // Thread for average of indices 0-2 (1-3)
        threads[0] = Thread.ofVirtual().start(() -> {
            avg[0] = (arr[0] + arr[1] + arr[2]) / 3.0;
        });
        // Thread for average of indices 3-5 (4-6)
        threads[1] = Thread.ofVirtual().start(() -> {
            avg[1] = (arr[3] + arr[4] + arr[5]) / 3.0;
        });
        // Thread for average of indices 6-9 (7-10)
        threads[2] = Thread.ofVirtual().start(() -> {
            avg[2] = (arr[6] + arr[7] + arr[8] + arr[9]) / 4.0;
        });
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.printf("Average of 1-3: %.2f\n", avg[0]);
        System.out.printf("Average of 4-6: %.2f\n", avg[1]);
        System.out.printf("Average of 7-10: %.2f\n", avg[2]);
        System.out.println("Averages array: " + Arrays.toString(avg));
    }
}
