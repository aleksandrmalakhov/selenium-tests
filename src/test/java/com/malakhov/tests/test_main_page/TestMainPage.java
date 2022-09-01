package com.malakhov.tests.test_main_page;

import com.malakhov.pages.MainPage;
import com.malakhov.tests.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainPage extends BaseTest {
    private final MainPage page = new MainPage();

    @Test
    void testTitle() {
        var textSales = page.getDiscountProduct().getTitle();
        var textNext = page.getNewProduct().getTitle();
        System.out.println(textSales);
        System.out.println(textNext);
    }

    @Test
    void Get_New_Product() {
        var newProductSection = page.getNewProduct();
        var notNew = newProductSection.getAllActiveProduct()
                .stream()
                .filter(product -> !product.isNew())
                .toList();

        assertEquals(0, notNew.size(), "These products don't contain the label 'Новый!'" + notNew);
    }

    @Test
    void Get_Discount_Product() {
        var discountProductSection = page.getDiscountProduct();
        var notDiscount = discountProductSection.getAllActiveProduct()
                .stream()
                .filter(product -> !product.isSale())
                .toList();

        assertEquals(0, notDiscount.size(), "These products don't contain the label 'Скидка!'" + notDiscount);
    }
}
