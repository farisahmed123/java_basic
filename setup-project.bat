@echo off
echo ========================================
echo Java Basic Project Setup
echo ========================================

REM Check if Java is installed
echo Checking Java installation...
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Java is not installed or not in PATH
    echo.
    echo Please install Java 21 or higher:
    echo - Download from: https://adoptium.net/
    echo - Or from: https://www.oracle.com/java/technologies/downloads/
    echo.
    echo After installation, add Java to your PATH and restart this script.
    pause
    exit /b 1
)

echo Java is installed:
java -version
echo.

REM Check if Gradle wrapper JAR exists
if exist "gradle\wrapper\gradle-wrapper.jar" (
    echo Gradle wrapper JAR found.
    goto :build_project
)

echo Gradle wrapper JAR not found.
echo.

REM Try automatic download first
echo Attempting automatic download...
call download-gradle.bat

REM Check if download was successful
if exist "gradle\wrapper\gradle-wrapper.jar" (
    echo.
    echo Automatic download successful!
    goto :build_project
)

echo.
echo ========================================
echo MANUAL SETUP REQUIRED
echo ========================================
echo.
echo Please follow these steps:
echo.
echo 1. Open your web browser
echo 2. Go to: https://github.com/gradle/gradle/raw/v7.6.0/gradle/wrapper/gradle-wrapper.jar
echo 3. Save the file as: gradle\wrapper\gradle-wrapper.jar
echo.
echo OR copy this URL and download manually:
echo https://github.com/gradle/gradle/raw/v7.6.0/gradle/wrapper/gradle-wrapper.jar
echo.
echo After downloading, press any key to continue...
pause

REM Check again after manual download
if exist "gradle\wrapper\gradle-wrapper.jar" (
    echo.
    echo File found! Proceeding with build...
    goto :build_project
) else (
    echo.
    echo File still not found. Please ensure you saved it as:
    echo gradle\wrapper\gradle-wrapper.jar
    echo.
    echo Current directory structure:
    dir gradle\wrapper\ 2>nul || echo gradle\wrapper\ directory not found
    echo.
    pause
    exit /b 1
)

:build_project
echo.
echo ========================================
echo Building Project
echo ========================================

REM Build the project
gradlew.bat build

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo SETUP COMPLETE!
    echo ========================================
    echo.
    echo Your Java project is ready!
    echo.
    echo To run the application:
    echo   run.bat
    echo.
    echo Or manually:
    echo   java -jar build\libs\java_basic-1.0.0.jar
    echo.
    echo To rebuild:
    echo   build.bat
    echo.
) else (
    echo.
    echo ========================================
    echo BUILD FAILED
    echo ========================================
    echo Check the error messages above.
    echo.
)

pause 