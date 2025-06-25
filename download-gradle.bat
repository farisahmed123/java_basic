@echo off
echo ========================================
echo Gradle Wrapper Download Script
echo ========================================

REM Create the directory if it doesn't exist
if not exist "gradle\wrapper" mkdir "gradle\wrapper"

echo Attempting to download Gradle wrapper JAR...

REM Try using curl if available
curl --version >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    echo Using curl to download...
    curl -L -o "gradle\wrapper\gradle-wrapper.jar" "https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar"
    goto :check_download
)

REM Try using wget if available
wget --version >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    echo Using wget to download...
    wget -O "gradle\wrapper\gradle-wrapper.jar" "https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar"
    goto :check_download
)

REM Try using PowerShell if available
powershell -Command "Get-Command Invoke-WebRequest" >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    echo Using PowerShell to download...
    powershell -Command "Invoke-WebRequest -Uri 'https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar' -OutFile 'gradle\wrapper\gradle-wrapper.jar'"
    goto :check_download
)

echo.
echo ========================================
echo AUTOMATIC DOWNLOAD FAILED
echo ========================================
echo.
echo No download tools found on your system.
echo.
echo MANUAL DOWNLOAD INSTRUCTIONS:
echo ========================================
echo 1. Open your web browser
echo 2. Go to: https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar
echo 3. Save the file as: gradle\wrapper\gradle-wrapper.jar
echo.
echo OR use one of these alternative methods:
echo.
echo Method 1 - Using curl (if you have it):
echo   curl -L -o gradle\wrapper\gradle-wrapper.jar https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar
echo.
echo Method 2 - Using wget (if you have it):
echo   wget -O gradle\wrapper\gradle-wrapper.jar https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar
echo.
echo Method 3 - Using PowerShell:
echo   powershell -Command "Invoke-WebRequest -Uri 'https://github.com/gradle/gradle/raw/v8.5.0/gradle/wrapper/gradle-wrapper.jar' -OutFile 'gradle\wrapper\gradle-wrapper.jar'"
echo.
goto :end

:check_download
if exist "gradle\wrapper\gradle-wrapper.jar" (
    echo.
    echo ========================================
    echo DOWNLOAD SUCCESSFUL!
    echo ========================================
    echo File downloaded to: gradle\wrapper\gradle-wrapper.jar
    echo File size:
    dir "gradle\wrapper\gradle-wrapper.jar"
    echo.
    echo You can now run: build.bat
) else (
    echo.
    echo ========================================
    echo DOWNLOAD FAILED
    echo ========================================
    echo Please use the manual download instructions above.
)

:end
pause 