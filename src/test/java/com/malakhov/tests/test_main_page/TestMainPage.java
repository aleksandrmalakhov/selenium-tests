package com.malakhov.tests.test_main_page;

import com.malakhov.pages.MainPage;
import com.malakhov.tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тест главной станицы сайта")
public class TestMainPage extends BaseTest {
    private final MainPage page = new MainPage();

    @Test
    @DisplayName("Тест группы товаров 'Новые поступления'")
    @Description("Получение товаров из группы 'Новые поступления' и проверка присутствия соответствующего лейбла")
    void Get_New_Product() {
        var newProductSection = page.getNewProduct();
        var notNew = newProductSection.getAllActiveProduct()
                .stream()
                .filter(product -> !product.isNew())
                .toList();

        assertEquals(0, notNew.size(), "These products don't contain the label 'Новый!'" + notNew);
    }

    @Test
    @DisplayName("Тест группы товаров 'Распродажа'")
    @Description("Получение товаров из группы 'Распродажа' и проверка присутствия соответствующего лейбла")
    void Get_Discount_Product() {
        var discountProductSection = page.getDiscountProduct();
        var notDiscount = discountProductSection.getAllActiveProduct()
                .stream()
                .filter(product -> !product.isSale())
                .toList();

        assertEquals(0, notDiscount.size(), "These products don't contain the label 'Скидка!'" + notDiscount);
    }
}