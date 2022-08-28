package com.malakhov;

import com.malakhov.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractElement {
    protected WebDriver driver = BaseTest.getDriver();
    protected WebDriverWait wait = BaseTest.getWait();
    protected Actions actions = new Actions(driver);

    public AbstractElement() {
//        driver = BaseTest.getDriver();
//        wait = BaseTest.getWait();
        PageFactory.initElements(driver, this);
    }
}