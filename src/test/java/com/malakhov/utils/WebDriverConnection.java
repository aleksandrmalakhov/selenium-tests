package com.malakhov.utils;

import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.malakhov.utils.Config.*;

public class WebDriverConnection {
    private WebDriver driver;
    private static WebDriverConnection instance;

    private WebDriverConnection() {
        System.setProperty(WEBDRIVER_PROPERTY, getWebDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static WebDriverConnection getInstanceWebDriver() {
        if (instance == null) {
            instance = new WebDriverConnection();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void instanceKill() {
        instance = null;
    }

    private static @NonNull String getWebDriverPath() {
        var osName = System.getProperty("os.name").split("\s")[0].toLowerCase();
        if (osName.contains("lin")) {
            return LINUX_DRIVER_PATH;
        } else if (osName.contains("win")) {
            return WINDOWS_DRIVER_PATH;
        } else if (osName.contains("mac")) {
            return MAC_DRIVER_PATH;
        } else {
            throw new RuntimeException("The operating system has not been identified.");
        }
    }
}