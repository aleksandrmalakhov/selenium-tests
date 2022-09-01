package com.malakhov.elements.product;

import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class DiscountProduct extends Product {
    private final boolean isSale;

    public DiscountProduct(@NonNull WebElement element) {
        super(element);
        this.isSale = this.isSale(element);
    }

    @Override
    public boolean isNew() {
        return false;
    }
}