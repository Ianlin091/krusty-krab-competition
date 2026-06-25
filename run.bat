@echo off
chcp 65001 > nul
set "JAVA_PATH=C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.4\jbr\bin\java.exe"

:: 檢查 IntelliJ JDK 是否存在
if exist "%JAVA_PATH%" (
    echo [INFO] 使用 IntelliJ 內建 JDK 啟動遊戲中...
    "%JAVA_PATH%" -cp bin krusty_krab_competition.KrustyKrab_Controller
) else (
    :: 檢查系統全域 java
    where java >nul 2>nul
    if %errorlevel% equ 0 (
        echo [INFO] 使用系統環境變數 java 啟動遊戲中...
        java -cp bin krusty_krab_competition.KrustyKrab_Controller
    ) else (
        echo [ERROR] 找不到任何可用的 Java 環境！
        echo 請確認是否有安裝 JDK，或手動修改此 .bat 檔中的 JAVA_PATH。
        pause
    )
)
