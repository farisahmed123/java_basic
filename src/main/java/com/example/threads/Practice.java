package com.example.threads;
import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int n=50;
        int []arr = new int[n];
        Random rand = new Random();
        for(int i=0;i<n;i++)
        {
            arr[i]=rand.nextInt(   41) + 10;
            System.out.println(arr[i]);
        }
        System.out.println("Want to find the Average of each 10 by 10");


        int window_size = 10;
        int m = n-window_size+1;
        int threada = n/window_size;
        int chunk = (m+threada-1)/threada;
        List<Thread> threads = new ArrayList<>();
        OptionalDouble[] result = new OptionalDouble[n];
        Arrays.fill(result, OptionalDouble.empty());

        for(int i=0;i<threada;i++){
            int start = i*chunk;
            int end = Math.min(m,start+chunk);
            Thread vt = Thread.ofVirtual().start(() -> {
                for (int j = start; j < end; j++) {
                    int sum = 0;
                    for(int k=j;k<j+window_size;k++)
                    {
                        sum+=arr[k];
                    }
                    result[j+window_size-1] = OptionalDouble.of(sum / (double) window_size);
                }
            });
            threads.add(vt);
        }
        for (Thread thread : threads) {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
            }
        }
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
