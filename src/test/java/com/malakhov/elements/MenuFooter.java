package com.malakhov.elements;

import com.malakhov.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuFooter extends BaseElement {
    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Главная')]")
    private WebElement linkMainPage;

    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Все товары')]")
    private WebElement linkCatalogPage;

    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Мой аккаунт')]")
    private WebElement linkAccountPage;

    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Корзина')]")
    private WebElement linkCartPage;

    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Оформление заказа')]")
    private WebElement linkCheckoutPage;

    @FindBy(xpath = "//*[contains(@class, 'widget_pages')]//*[contains(text(), 'Регистрация')]")
    private WebElement linkRegistrationPage;

    public MenuFooter() {
        super();
    }

    @Step("Click to link main page from footer")
    public MainPage goToMainPage() {
        actions.scrollToElement(linkMainPage).perform();
        linkMainPage.click();
        return new MainPage();
    }

    @Step("Click to link catalog page from footer")
    public CatalogPage goToCatalogPage() {
        actions.scrollToElement(linkCatalogPage).perform();
        linkCatalogPage.click();
        return new CatalogPage();
    }

    @Step("Click to link account page from footer")
    public MyAccountPage goToAccountPage() {
        actions.scrollToElement(linkAccountPage).perform();
        linkAccountPage.click();
        return new MyAccountPage();
    }

    @Step("Click to link cart page from footer")
    public CartPage goToCartPage() {
        actions.scrollToElement(linkCartPage).perform();
        linkCartPage.click();
        return new CartPage();
    }

    @Step("Click to link checkout page from footer")
    public CheckoutPage goToCheckoutPage() {
        actions.scrollToElement(linkCheckoutPage).perform();
        linkCheckoutPage.click();
        return new CheckoutPage();
    }

    @Step("Click to link registration page from footer")
    public RegistrationPage goToRegistrationPage() {
        actions.scrollToElement(linkRegistrationPage).perform();
        linkRegistrationPage.click();
        return new RegistrationPage();
    }
}
