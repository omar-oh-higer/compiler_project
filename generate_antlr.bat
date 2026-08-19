@echo off
REM ANTLR Code Generator Script for compiler_project (Windows)

echo ========================================
echo Generating ANTLR Lexer and Parser Files
echo ========================================

set ANTLR_JAR=dependencies\antlr-4.13.2-complete.jar
if not exist "%ANTLR_JAR%" (
    echo ANTLR jar not found at %ANTLR_JAR%
    echo Place antlr-4.13.2-complete.jar inside the dependencies\ folder.
    pause
    exit /b 1
)

if not exist "gen\gen" mkdir gen\gen

echo.
echo Generating GreetLexer...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen grammar\GreetLexer.g4
if errorlevel 1 (
    echo Failed to generate GreetLexer
    pause
    exit /b 1
)

echo Generating GreetParser...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen -lib gen\gen grammar\GreetParser.g4
if errorlevel 1 (
    echo Failed to generate GreetParser
    pause
    exit /b 1
)

echo Generating PyLexer...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen grammar\PyLexer.g4
if errorlevel 1 (
    echo Failed to generate PyLexer
    pause
    exit /b 1
)

echo Generating PyParser...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen -lib gen\gen grammar\PyParser.g4
if errorlevel 1 (
    echo Failed to generate PyParser
    pause
    exit /b 1
)

echo Generating TplLexer...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen grammar\TplLexer.g4
if errorlevel 1 (
    echo Failed to generate TplLexer
    pause
    exit /b 1
)

echo Generating TplParser...
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -visitor -listener -o gen\gen -package gen -lib gen\gen grammar\TplParser.g4
if errorlevel 1 (
    echo Failed to generate TplParser
    pause
    exit /b 1
)

if exist "gen\gen\grammar" (
    echo Moving files from gen\gen\grammar to gen\gen...
    move /Y gen\gen\grammar\* gen\gen\
    rmdir gen\gen\grammar
)

echo.
echo ========================================
echo ANTLR Code Generation Complete!
echo ========================================
echo.
echo Generated files are in: gen\gen\
echo.
pause
