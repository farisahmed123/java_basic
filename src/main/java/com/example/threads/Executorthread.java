package com.example.threads;
import java.util.*;

public class Executorthread {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4};
        Thread[] th = new Thread[4];
        th[0] = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2;
            }
        });
        th[1] = Thread.ofVirtual().start(() -> {
            System.out.println("Values of Arrays : " + Arrays.toString(arr));
        });
        th[2] = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 3;
            }
        });
        th[3] = Thread.ofVirtual().start(() -> {
            // Print the array in reverse order
            System.out.print("Array in reverse: ");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i] + (i > 0 ? ", " : "\n"));
            }
        });
        for (Thread t : th) {
            t.join();
        }
    }
}
    