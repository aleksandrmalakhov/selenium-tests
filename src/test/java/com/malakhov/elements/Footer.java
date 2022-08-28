package com.malakhov.elements;

import com.malakhov.pages.*;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class Footer extends BaseElement {
    @FindBy(xpath = "//*[contains(@class, 'cta-banner')]//*[contains(text(), 'Телефон')]/parent::*")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[contains(@class, 'cta-banner')]//*[contains(text(), 'Email')]/parent::*")
    private WebElement email;

    private final MenuFooter menu;

    public Footer() {
        super();
        menu = new MenuFooter();
    }

    @Step("Get phone number from footer")
    public String getPhoneNumber() {
        actions.scrollToElement(phoneNumber).perform();
        return wait.until(ExpectedConditions.visibilityOf(phoneNumber)).getText().split(":")[1].trim();
    }

    @Step("Get email from footer")
    public String getEmail() {
        actions.scrollToElement(email).perform();
        return wait.until(ExpectedConditions.visibilityOf(email)).getText().split(":")[1].trim();
    }

    public MainPage openMainPage() {
        return menu.goToMainPage();
    }

    public CatalogPage openCatalogPage() {
        return menu.goToCatalogPage();
    }

    public MyAccountPage openAccountPage() {
        return menu.goToAccountPage();
    }

    public CartPage openCartPage() {
        return menu.goToCartPage();
    }

    public CheckoutPage openCheckoutPage() {
        return menu.goToCheckoutPage();
    }

    public RegistrationPage openRegistrationPage() {
        return menu.goToRegistrationPage();
    }
}