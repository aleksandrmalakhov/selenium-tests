package com.malakhov.tests;

import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.malakhov.utils.Config.URL;
import static com.malakhov.utils.WebDriverConnection.getInstanceWebDriver;
import static com.malakhov.utils.WebDriverConnection.instanceKill;

public abstract class BaseTest {
    @Getter
    private static WebDriver driver;
    @Getter
    private static WebDriverWait wait;

    @BeforeAll
    static void beforeAll() {
        driver = getInstanceWebDriver().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
        instanceKill();
    }
}
