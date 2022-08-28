package com.malakhov.tests;

import com.malakhov.elements.Footer;
import com.malakhov.elements.Header;
import com.malakhov.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Тест элементов Header и Footer")
public class TestElementsHeaderAndFooter extends BaseTest {
    private final Header header = new MainPage().getHeader();
    private final Footer footer = new MainPage().getFooter();

    @Test
    @DisplayName("Открытие главной страницы сайта")
    void testOpenMainPage() {
        var expected = "Skillbox — Интернет магазин";
        header.openMainPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openMainPage();
        assertThat(expected);
    }

    @Test
    @DisplayName("Открытие страницы каталога")
    void testOpenCatalogPage() {
        var expected = "Каталог — Skillbox";
        header.openCatalogPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openCatalogPage();
        assertThat("Товары — Skillbox");
    }

    @Test
    @DisplayName("Открытие страницы аккаунта")
    void testOpenAccountPage() {
        var expected = "Мой аккаунт — Skillbox";
        header.openAccountPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openAccountPage();
        assertThat(expected);
    }

    @Test
    @DisplayName("Открытие страницы корзины")
    void testOpenCartPage() {
        var expected = "Корзина — Skillbox";
        header.openCartPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openCartPage();
        assertThat(expected);
    }

    @Test
    @DisplayName("Открытие страницы оформления заказа")
    void testOpenCheckoutPage() {
        var expected = "Корзина пуста.";
        header.openCheckoutPage();
        var actualHeader = getElementText(By.cssSelector(".cart-empty"));
        assertEquals(expected, actualHeader);

        header.goToMainPage();
        footer.openCheckoutPage();
        var actualFooter = getElementText(By.cssSelector(".cart-empty"));
        assertEquals(expected, actualFooter);
    }

    @Test
    @DisplayName("Открытие страницы регистрации")
    void testOpenRegistrationPage() {
        var expected = "Регистрация — Skillbox";

        footer.openRegistrationPage();
        assertThat(expected);
    }

    @Test
    @DisplayName("Клик по кнопке \"Войти\"")
    void testClickToLogin() {
        var expected = "Мой аккаунт — Skillbox";
        header.login();
        assertThat(expected);
    }

    @Test
    @DisplayName("Получение номера телефона и email")
    void testGetPhoneNumberAndEmail() {
        var expected = "+7-999-123-12-12\nskillbox@skillbox.ru";
        header.goToMainPage();
        var actualHeader = header.getPhoneNumber() + "\n" + header.getEmail();
        var actualFooter = footer.getPhoneNumber() + "\n" + footer.getEmail();

        assumeTrue(actualHeader.equals(actualFooter));
        assertEquals(expected, actualHeader);
    }

    @Test
    @DisplayName("Тест поля поиска по  сайту")
    void testFunctionSearch() {
        var expected = "Search Results for “Привет” — Skillbox";
        header.searchData("Привет");
        assertThat(expected);
    }

    @Test
    @DisplayName("Клик по логотипу и переход на главную страницу")
    void testClickToLogo() {
        var expected = "Skillbox — Интернет магазин";
        var subExpected = "Корзина — Skillbox";

        header.openCartPage();
        var subActual = getDriver().getTitle();
        assumeTrue(subExpected.equals(subActual));

        header.goToMainPage();
        assertThat(expected);
    }

    private void assertThat(String expected) {
        var actual = getDriver().getTitle();
        assertEquals(expected, actual);
    }

    private String getElementText(By locator) {
        return getDriver().findElement(locator).getText();
    }
}
