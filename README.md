# Java Hello World Console Application

A comprehensive Java console application that demonstrates basic console input operations using Gradle as the build system.

## Features

This application showcases various console input techniques:

- **Basic String Input**: Reading names and text from the console
- **Data Type Validation**: Reading integers, doubles, and booleans with input validation
- **Multiple Word Input**: Handling multi-word strings
- **Character Input**: Reading single characters
- **Multiple Values**: Parsing space-separated values on one line
- **Interactive Menu**: A simple menu system with user choices
- **Error Handling**: Robust input validation and exception handling

## Prerequisites

- Java 11 or higher
- Gradle (will be downloaded automatically via wrapper)

## Project Structure

```
java_basic/
├── build.gradle                 # Gradle build configuration
├── gradle/wrapper/              # Gradle wrapper files
│   └── gradle-wrapper.properties
├── gradlew                      # Unix/Linux Gradle wrapper script
├── gradlew.bat                  # Windows Gradle wrapper script
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── HelloWorldApp.java  # Main application
└── README.md                    # This file
```

## Getting Started

### 1. Build the Project

On Windows:
```bash
.\gradlew.bat build
```

On Unix/Linux/macOS:
```bash
./gradlew build
```

### 2. Run the Application

On Windows:
```bash
.\gradlew.bat run
```

On Unix/Linux/macOS:
```bash
./gradlew run
```

### 3. Alternative: Run the JAR file

After building, you can also run the generated JAR file:
```bash
java -jar build/libs/java_basic-1.0.0.jar
```

## Application Demo

When you run the application, it will guide you through several interactive demos:

1. **Name Input**: Enter your name
2. **Personal Information**: Enter age, height, and student status
3. **Programming Language**: Enter your favorite programming language
4. **Character Input**: Enter a single character
5. **Multiple Numbers**: Enter three numbers separated by spaces
6. **Interactive Menu**: Choose from options 1-3

## Example Session

```
=== Hello World Console Application ===
Welcome to the Java Console Input Demo!

Demo 1: Basic String Input
Please enter your name: John Doe
Hello, John Doe! Welcome to Java programming!

Demo 2: Reading Different Data Types
Enter your age (integer): 25
Enter your height in meters (decimal): 1.75
Are you a student? (true/false): true

--- Your Information ---
Name: John Doe
Age: 25
Height: 1.75 meters
Student: true

Demo 3: Reading Multiple Words
Enter your favorite programming language: Java
Great choice! Java is an excellent language.

Demo 4: Reading a Single Character
Enter a single character (first letter of your favorite color): B
You entered: 'B'

Demo 5: Reading Multiple Values
Enter three numbers separated by spaces (e.g., 10 20 30): 15 25 35
Numbers entered: 15, 25, 35
Sum: 75
Average: 25.0

Demo 6: Interactive Menu
Choose an option:
1. Say hello
2. Show current time
3. Exit
Enter your choice (1-3): 2
Current time: 14:30:45.123
Enter your choice (1-3): 3
Goodbye! Thanks for using the application!

=== Application completed successfully! ===
```

## Key Learning Points

### Console Input Techniques

1. **Scanner Class**: The primary way to read console input in Java
2. **Input Validation**: Using `hasNextInt()`, `hasNextDouble()`, etc. to validate input
3. **Buffer Management**: Properly consuming newline characters with `nextLine()`
4. **Exception Handling**: Using try-catch blocks for robust error handling
5. **Resource Management**: Always closing the Scanner to prevent resource leaks

### Best Practices Demonstrated

- Input validation before processing
- Proper error messages for invalid input
- Resource cleanup in finally blocks
- Clear user prompts and feedback
- Modular code structure with comments

## Gradle Commands

- `gradlew build` - Build the project
- `gradlew run` - Run the application
- `gradlew clean` - Clean build artifacts
- `gradlew test` - Run tests (if any)
- `gradlew jar` - Create executable JAR file

## Troubleshooting

### Common Issues

1. **Permission Denied**: Make sure the gradlew script is executable:
   ```bash
   chmod +x gradlew
   ```

2. **Java Version**: Ensure you have Java 11+ installed:
   ```bash
   java -version
   ```

3. **Gradle Wrapper**: If gradlew doesn't work, you can install Gradle globally and use `gradle` instead of `./gradlew`

## Contributing

Feel free to extend this application with additional console input features or improvements!

## License

This project is open source and available under the MIT License. 