@echo off
echo ========================================
echo Manual Java Application Runner
echo ========================================

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed or not in PATH
    pause
    exit /b 1
)

REM Check if the JAR file exists
if not exist "build\libs\java_basic-1.0.0.jar" (
    echo JAR file not found. Building project first...
    call build-manual.bat
    if not exist "build\libs\java_basic-1.0.0.jar" (
        echo Build failed. Cannot run application.
        pause
        exit /b 1
    )
)

echo.
echo Starting application...
echo ========================================

REM Run the application
java -jar build\libs\java_basic-1.0.0.jar

echo.
echo ========================================
echo Application finished.
echo ========================================
pause 