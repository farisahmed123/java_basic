@echo off
echo ========================================
echo Simple Java Project Build
echo ========================================

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed or not in PATH
    pause
    exit /b 1
)

echo Java version:
java -version
echo.

REM Check if Gradle wrapper files exist
if not exist "gradle\wrapper\gradle-wrapper.jar" (
    echo ERROR: Gradle wrapper JAR not found
    echo Please run: download-gradle.bat
    pause
    exit /b 1
)

if not exist "gradle\wrapper\gradle-wrapper.properties" (
    echo ERROR: Gradle wrapper properties not found
    pause
    exit /b 1
)

echo Gradle wrapper files found.
echo.

REM Set local Gradle cache to avoid permission issues
set GRADLE_USER_HOME=.\gradle-cache
echo Using local Gradle cache: %GRADLE_USER_HOME%

REM Create cache directory
if not exist "gradle-cache" mkdir "gradle-cache"

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
    echo   java -jar build\libs\java_basic-1.0.0.jar
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