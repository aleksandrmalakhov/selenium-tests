package com.malakhov.elements.product;

import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Getter
public class DiscountProduct extends Product<DiscountProduct> {
    private final boolean isSale;

    public DiscountProduct(@NonNull WebElement element) {
        super(element);
        this.isSale = this.isSale(element);
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public int compareTo(@NonNull DiscountProduct product) {
        return product.compareTo(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        DiscountProduct product = (DiscountProduct) obj;
        return Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getShortDesc(), product.getShortDesc()) &&
                Objects.equals(getOldPrice(), product.getOldPrice()) &&
                Objects.equals(getNewPrice(), product.getNewPrice());
    }
}