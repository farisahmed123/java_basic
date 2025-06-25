@echo off
echo ========================================
echo Java Basic Project Build Script
echo ========================================

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 or higher and add it to your PATH
    pause
    exit /b 1
)

echo Java version:
java -version

REM Check if Gradle wrapper JAR exists
if not exist "gradle\wrapper\gradle-wrapper.jar" (
    echo Gradle wrapper JAR not found. Downloading...
    call download-gradle.bat
    if not exist "gradle\wrapper\gradle-wrapper.jar" (
        echo Failed to download Gradle wrapper. Please run download-gradle.bat manually.
        pause
        exit /b 1
    )
)

echo.
echo Building project...
echo ========================================

REM Build the project
gradlew.bat build

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo BUILD SUCCESSFUL!
    echo ========================================
    echo.
    echo To run the application:
    echo   gradlew.bat run
    echo.
    echo Or run the JAR directly:
    echo   java -jar build\libs\java_basic-1.0.0.jar
    echo.
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
    echo Check the error messages above.
)

pause 