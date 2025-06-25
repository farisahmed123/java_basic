package com.example;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Loops{
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        String [] head;
        String type;
        int amount;
        String date;
        System.out.println("1. Income : ");
        System.out.println("2. Expense : ");
        System.out.println("3. show report : ");
        System.out.println("4. Exit : ");
        int choice = sc.nextInt();
        while(true){
            switch ((choice)) {
                case 1:
                sc.nextLine(); // consume leftover newline
                System.out.println("Income, Enter head : ");
                head = new String[3]; // Example initialization, adjust as needed
                for (int i = 0; i < head.length; i++) {
                    head[i] = sc.nextLine();
                }
                // for (String h : head) {
                //     i
                // }
                break;
                case 2:
                // add("Expense");
                break;
                case 3:
                // showreport();
                break;
                case 4:
                return;
                default:
                System.out.println("Enter Valid Input");
            }
        }
 }
//  private static void add(String type){
//     System.out.println(type+" Enter : "+head);
//  }
}
