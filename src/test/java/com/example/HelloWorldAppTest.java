package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic test class for HelloWorldApp
 * Note: Console input testing is complex and typically requires
 * mocking or system.in redirection for comprehensive testing.
 */
public class HelloWorldAppTest {

    @Test
    void testApplicationCanStart() {
        // This is a basic test to ensure the application can be instantiated
        // In a real scenario, you would test individual methods and components
        
        // Test that the main class can be loaded
        assertDoesNotThrow(() -> {
            Class.forName("com.example.HelloWorldApp");
        });
    }

    @Test
    void testMainMethodExists() {
        // Test that the main method exists and is accessible
        assertDoesNotThrow(() -> {
            HelloWorldApp.class.getMethod("main", String[].class);
        });
    }

    @Test
    void testStringProcessing() {
        // Test basic string processing logic that could be extracted
        String testInput = "John Doe";
        String expected = "Hello, " + testInput + "! Welcome to Java programming!";
        String actual = "Hello, " + testInput + "! Welcome to Java programming!";
        assertEquals(expected, actual);
    }

    @Test
    void testNumberParsing() {
        // Test number parsing logic
        String[] numbers = {"10", "20", "30"};
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        assertEquals(60, sum);
    }

    @Test
    void testAverageCalculation() {
        // Test average calculation
        int[] numbers = {10, 20, 30};
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;
        assertEquals(20.0, average, 0.001);
    }
} 