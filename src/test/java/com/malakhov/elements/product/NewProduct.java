package com.malakhov.elements.product;

import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class NewProduct extends Product {
    private final boolean isNew;

    public NewProduct(@NonNull WebElement element) {
        super(element);
        this.isNew = this.isNew(element);
    }

    @Override
    public boolean isSale() {
        return false;
    }
}