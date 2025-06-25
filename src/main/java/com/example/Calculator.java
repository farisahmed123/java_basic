package com.example;

import java.util.Scanner;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Calculator");
        String choice = "yes";
        do {
            double num1 = 0, num2 = 0;
            boolean validInput = false;
            // Input validation for first number
            while (!validInput) {
                System.out.print("Enter first number: ");
                if (scanner.hasNextDouble()) {
                    num1 = scanner.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Please enter number only");
                    scanner.next(); // consume invalid input
                }
            }
            validInput = false;
            // Input validation for second number
            while (!validInput) {
                System.out.print("Enter second number: ");
                if (scanner.hasNextDouble()) {
                    num2 = scanner.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Please enter number only");
                    scanner.next(); // consume invalid input
                }
            }
            System.out.print("Choose operation (+, -, *, /): ");
            char op = scanner.next().charAt(0);
            double result = 0;
            switch (op) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation");
                    continue;
            }
            System.out.println("Result: " + result);
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));
        scanner.close();
        System.out.println("Calculator terminated.");
    }
} 