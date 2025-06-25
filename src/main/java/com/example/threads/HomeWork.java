package com.example.threads;
import java.util.*;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        int n = 2000;
        int window = 20;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(41) + 10; // random int between 10 and 50

        OptionalDouble[] result = new OptionalDouble[n];
        Arrays.fill(result, OptionalDouble.empty());

        int m = n - window + 1;
        int threads = Math.max(1, n / window);
        List<Thread> threadList = new ArrayList<>();
        int chunk = (m + threads - 1) / threads;

        for (int t = 0; t < threads; t++) {
            int start = t * chunk;
            int end = Math.min(m, start + chunk);
            Thread vt = Thread.ofVirtual().start(() -> {
                for (int i = start; i < end; i++) {
                    int sum = 0;
                    for (int j = i; j < i + window; j++) {
                        sum += arr[j];
                    }
                    result[i + window - 1] = OptionalDouble.of(sum / (double) window);
                }
            });
            threadList.add(vt);
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        // Print first 20 array values
        System.out.println("First 20 array values: " + Arrays.toString(Arrays.copyOf(arr, 20)));
        // Print first 20 SMA values with their indices
        System.out.println("First 20 SMA values (index: value):");
        for (int i = 0; i < 21; i++) {
            if (result[i].isPresent()) {
                System.out.printf("%d: %.2f\n", i, result[i].getAsDouble());
            } else {
                System.out.printf("%d: N/A\n", i);
            }
        }
    }
}
