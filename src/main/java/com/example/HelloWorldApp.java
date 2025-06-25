package com.example;

import java.util.Scanner;

/**
 * Hello World Console Application with Basic Console Input Operations
 * This application demonstrates various ways to read input from the console
 * including strings, numbers, and handling different input scenarios.
 */
public class HelloWorldApp {
    
    public static void main(String[] args) {
        System.out.println("=== Hello World Console Application ===");
        System.out.println("Welcome to the Java Console Input Demo!");
        System.out.println();
        
        // Create a Scanner object to read from console
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Demo 1: Basic string input
            System.out.println("Demo 1: Basic String Input");
            System.out.print("Please enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "! Welcome to Java programming!");
            System.out.println();
            
            // Demo 2: Reading different data types
            System.out.println("Demo 2: Reading Different Data Types");
            
            System.out.print("Enter your age (integer): ");
            int age = 0;
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer for age: ");
                scanner.next(); // consume invalid input
            }
            age = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            
            System.out.print("Enter your height in meters (decimal): ");
            double height = 0.0;
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid decimal number for height: ");
                scanner.next(); // consume invalid input
            }
            height = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character
            
            System.out.print("Are you a student? (true/false): ");
            boolean isStudent = false;
            while (!scanner.hasNextBoolean()) {
                System.out.println("Please enter 'true' or 'false': ");
                scanner.next(); // consume invalid input
            }
            isStudent = scanner.nextBoolean();
            scanner.nextLine(); // consume the newline character
            
            // Display the collected information
            System.out.println("\n--- Your Information ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Height: " + height + " meters");
            System.out.println("Student: " + isStudent);
            System.out.println();
            
            // Demo 3: Reading multiple words and handling special cases
            System.out.println("Demo 3: Reading Multiple Words");
            System.out.print("Enter your favorite programming language: ");
            String language = scanner.nextLine();
            System.out.println("Great choice! " + language + " is an excellent language.");
            System.out.println();
            
            // Demo 4: Reading a single character
            System.out.println("Demo 4: Reading a Single Character");
            System.out.print("Enter a single character (first letter of your favorite color): ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                char firstChar = input.charAt(0);
                System.out.println("You entered: '" + firstChar + "'");
            } else {
                System.out.println("No character entered.");
            }
            System.out.println();
            
            // Demo 5: Reading multiple values on one line
            System.out.println("Demo 5: Reading Multiple Values");
            System.out.print("Enter three numbers separated by spaces (e.g., 10 20 30): ");
            String numbersInput = scanner.nextLine();
            String[] numbers = numbersInput.split("\\s+");
            
            if (numbers.length >= 3) {
                try {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    int num3 = Integer.parseInt(numbers[2]);
                    
                    int sum = num1 + num2 + num3;
                    double average = sum / 3.0;
                    
                    System.out.println("Numbers entered: " + num1 + ", " + num2 + ", " + num3);
                    System.out.println("Sum: " + sum);
                    System.out.println("Average: " + average);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter valid numbers separated by spaces.");
                }
            } else {
                System.out.println("Error: Please enter exactly three numbers separated by spaces.");
            }
            System.out.println();
            
            // Demo 6: Interactive menu
            System.out.println("Demo 6: Interactive Menu");
            System.out.println("Choose an option:");
            System.out.println("1. Say hello");
            System.out.println("2. Show current time");
            System.out.println("3. Exit");
            
            boolean menuActive = true;
            while (menuActive) {
                System.out.print("Enter your choice (1-3): ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    
                    switch (choice) {
                        case 1:
                            System.out.println("Hello there! Nice to meet you!");
                            break;
                        case 2:
                            System.out.println("Current time: " + java.time.LocalTime.now());
                            break;
                        case 3:
                            System.out.println("Goodbye! Thanks for using the application!");
                            menuActive = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    }
                } else {
                    System.out.println("Please enter a valid number (1-3).");
                    scanner.next(); // consume invalid input
                }
            }
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Always close the scanner to prevent resource leaks
            scanner.close();
        }
        
        System.out.println("\n=== Application completed successfully! ===");
    }
} 