package com.malakhov.pages;

import com.malakhov.elements.Footer;
import com.malakhov.elements.Header;
import com.malakhov.elements.product_section.NewProductSection;
import com.malakhov.elements.product_section.DiscountProductSection;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage extends BasePage {
    private final Header header;
    private final Footer footer;
    private final DiscountProductSection discountProduct;
    private final NewProductSection newProduct;

    public MainPage() {
        super();
        header = new Header();
        footer = new Footer();
        discountProduct = new DiscountProductSection(
                By.xpath("//*[contains(text(), 'Распродажа')]//ancestor::aside"),
                By.className("prod-title"),
                By.className("slick-prev"),
                By.className("slick-next"));

        newProduct = new NewProductSection(
                By.xpath("//*[contains(text(), 'Новые поступления')]//ancestor::aside"),
                By.className("prod-title"),
                By.className("slick-prev"),
                By.className("slick-next"));
    }
}