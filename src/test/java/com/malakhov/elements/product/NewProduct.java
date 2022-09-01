package com.malakhov.elements.product;

import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Getter
public class NewProduct extends Product<NewProduct> {
    private final boolean isNew;

    public NewProduct(@NonNull WebElement element) {
        super(element);
        this.isNew = this.isNew(element);
    }

    @Override
    public boolean isSale() {
        return false;
    }

    @Override
    public int compareTo(@NonNull NewProduct product) {
        return product.compareTo(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        NewProduct product = (NewProduct) obj;
        return Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getShortDesc(), product.getShortDesc()) &&
                Objects.equals(getOldPrice(), product.getOldPrice()) &&
                Objects.equals(getNewPrice(), product.getNewPrice());
    }
}