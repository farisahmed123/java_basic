package com.example.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class aa {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // ⏱️ Start timing

        int[] arr = new int[2000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10, 50); // values between 10 (inclusive) and 50 (exclusive)
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        int average = sum / arr.length;
        System.out.println("Average (single-threaded): " + average);

        long elapsedNanos = System.nanoTime() - startTime;
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(elapsedNanos);
        System.out.println("Total program time: " + elapsedMillis + " ms");
    }
}
