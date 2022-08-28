package com.malakhov.elements;

import com.malakhov.pages.*;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BaseElement {
    @FindBy(xpath = "//*[@class='before-top-header']//*[contains(@class, 'fa-phone')]/parent::*")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@class='before-top-header']//*[contains(@class, 'fa-envelope')]/parent::*")
    private WebElement email;

    @FindBy(css = "#site-branding a[href^='http']:first-of-type")
    private WebElement buttonMainPage;

    @FindBy(css = ".account")
    private WebElement buttonLogin;
    private final Search search;
    private final MenuHeader menu;

    public Header() {
        super();
        search = new Search();
        menu = new MenuHeader();
    }

    @Step("Get phone number from header")
    public String getPhoneNumber() {
        return phoneNumber.getText().trim();
    }

    @Step("Get email from header")
    public String getEmail() {
        return email.getText().trim();
    }

    @Step("Click to logo")
    public MainPage goToMainPage() {
        buttonMainPage.click();
        return new MainPage();
    }

    @Step("Click to button login")
    public MyAccountPage login() {
        buttonLogin.click();
        return new MyAccountPage();
    }

    public void searchData(String data) {
        search.setData(data);
        search.search();
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
}