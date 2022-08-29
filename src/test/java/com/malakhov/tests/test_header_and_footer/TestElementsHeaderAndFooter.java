package com.malakhov.tests.test_header_and_footer;

import com.malakhov.elements.Footer;
import com.malakhov.elements.Header;
import com.malakhov.pages.MainPage;
import com.malakhov.tests.BaseTest;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Тест элементов Header и Footer")
public class TestElementsHeaderAndFooter extends BaseTest {
    private final Header header = new MainPage().getHeader();
    private final Footer footer = new MainPage().getFooter();

    @TmsLink("C1")
    @Test
    @DisplayName("Открытие главной страницы сайта")
    void Open_Main_Page() {
        var expected = "Skillbox — Интернет магазин";
        header.openMainPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openMainPage();
        assertThat(expected);
    }

    @TmsLink("C2")
    @Test
    @DisplayName("Открытие страницы каталога")
    void Open_Catalog_Page() {
        var expected = "Каталог — Skillbox";
        header.openCatalogPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openCatalogPage();
        assertThat("Товары — Skillbox");
    }

    @TmsLink("C3")
    @Test
    @DisplayName("Открытие страницы аккаунта")
    void Open_Account_Page() {
        var expected = "Мой аккаунт — Skillbox";
        header.openAccountPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openAccountPage();
        assertThat(expected);
    }

    @TmsLink("C4")
    @Test
    @DisplayName("Открытие страницы корзины")
    void Open_Cart_Page() {
        var expected = "Корзина — Skillbox";
        header.openCartPage();
        assertThat(expected);

        header.goToMainPage();
        footer.openCartPage();
        assertThat(expected);
    }

    @TmsLink("C5")
    @Test
    @DisplayName("Открытие страницы оформления заказа")
    void Open_Checkout_Page() {
        var expected = "Корзина пуста.";
        header.openCheckoutPage();
        var actualHeader = getElementText(By.cssSelector(".cart-empty"));
        assertEquals(expected, actualHeader);

        header.goToMainPage();
        footer.openCheckoutPage();
        var actualFooter = getElementText(By.cssSelector(".cart-empty"));
        assertEquals(expected, actualFooter);
    }

    @TmsLink("C6")
    @Test
    @DisplayName("Открытие страницы регистрации")
    void Open_Registration_Page() {
        var expected = "Регистрация — Skillbox";

        footer.openRegistrationPage();
        assertThat(expected);
    }

    @TmsLink("C7")
    @Test
    @DisplayName("Клик по кнопке \"Войти\"")
    void Click_To_Login() {
        var expected = "Мой аккаунт — Skillbox";
        header.login();
        assertThat(expected);
    }

    @TmsLink("C8")
    @Test
    @DisplayName("Получение номера телефона и email")
    void Get_Phone_Number_And_Email() {
        var expected = "+7-999-123-12-12\nskillbox@skillbox.ru";
        header.goToMainPage();
        var actualHeader = header.getPhoneNumber() + "\n" + header.getEmail();
        var actualFooter = footer.getPhoneNumber() + "\n" + footer.getEmail();

        assumeTrue(actualHeader.equals(actualFooter));
        assertEquals(expected, actualHeader);
    }

    @TmsLink("C9")
    @Test
    @DisplayName("Тест поля поиска по  сайту")
    void Search_Product() {
        var expected = "Search Results for “Привет” — Skillbox";
        header.searchData("Привет");
        assertThat(expected);
    }

    @TmsLink("C10")
    @Test
    @DisplayName("Клик по логотипу и переход на главную страницу")
    void Click_To_Logo() {
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
