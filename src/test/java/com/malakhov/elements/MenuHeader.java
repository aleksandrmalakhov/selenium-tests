package com.malakhov.elements;

import com.malakhov.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuHeader extends BaseElement {
    @FindBy(xpath = "//*[@class='store-menu']//*[contains(text(), 'Главная')]")
    private WebElement linkMainPage;

    @FindBy(xpath = "//*[@class='store-menu']//*[contains(text(), 'Каталог')]")
    private WebElement linkCatalogPage;

    @FindBy(xpath = "//*[@class='store-menu']//*[contains(text(), 'Мой аккаунт')]")
    private WebElement linkAccountPage;

    @FindBy(xpath = "//*[@class='store-menu']//*[contains(text(), 'Корзина')]")
    private WebElement linkCartPage;

    @FindBy(xpath = "//*[@class='store-menu']//*[contains(text(), 'Оформление заказа')]")
    private WebElement linkCheckoutPage;

    public MenuHeader() {
        super();
    }

    @Step("Click to link main page from header")
    public MainPage goToMainPage() {
        linkMainPage.click();
        return new MainPage();
    }

    @Step("Click to link catalog page from header")
    public CatalogPage goToCatalogPage() {
        linkCatalogPage.click();
        return new CatalogPage();
    }

    @Step("Click to link account page from header")
    public MyAccountPage goToAccountPage() {
        linkAccountPage.click();
        return new MyAccountPage();
    }

    @Step("Click to link cart page from header")
    public CartPage goToCartPage() {
        linkCartPage.click();
        return new CartPage();
    }

    @Step("Click to link checkout page from header")
    public CheckoutPage goToCheckoutPage() {
        linkCheckoutPage.click();
        return new CheckoutPage();
    }
}