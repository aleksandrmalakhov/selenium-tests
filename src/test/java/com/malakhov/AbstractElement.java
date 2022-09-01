package com.malakhov;

import com.malakhov.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractElement {
    protected WebDriver driver = BaseTest.getDriver();
    protected WebDriverWait wait = BaseTest.getWait();
    protected Actions actions = new Actions(driver);

    public AbstractElement() {
//        driver = BaseTest.getDriver();
//        wait = BaseTest.getWait();
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
}