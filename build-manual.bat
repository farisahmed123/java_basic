@echo off
echo ========================================
echo Manual Java Project Build
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

REM Create build directories
echo Creating build directories...
if not exist "build\classes" mkdir "build\classes"
if not exist "build\libs" mkdir "build\libs"

REM Clean previous build
echo Cleaning previous build...
if exist "build\classes\*" del /q "build\classes\*"
if exist "build\libs\java_basic-1.0.0.jar" del "build\libs\java_basic-1.0.0.jar"

echo.
echo Compiling Java source files...
echo ========================================

REM Compile Java files
javac -d build\classes -cp . src\main\java\com\example\HelloWorldApp.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo COMPILATION FAILED!
    echo ========================================
    echo Check the error messages above.
    pause
    exit /b 1
)

echo Compilation successful!
echo.

echo Creating JAR file...
echo ========================================

REM Create JAR file
jar cfm build\libs\java_basic-1.0.0.jar manifest.txt -C build\classes .

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo JAR CREATION FAILED!
    echo ========================================
    echo Check the error messages above.
    pause
    exit /b 1
)

echo JAR creation successful!
echo.

echo ========================================
echo BUILD SUCCESSFUL!
echo ========================================
echo.
echo JAR file created: build\libs\java_basic-1.0.0.jar
echo.
echo To run the application:
echo   java -jar build\libs\java_basic-1.0.0.jar
echo.
echo Or use: run-manual.bat
echo.

pause 