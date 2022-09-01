package com.malakhov.elements.product_section;

import com.malakhov.elements.product.AbstractProduct;
import com.malakhov.elements.product.DiscountProduct;
import org.openqa.selenium.By;

import java.util.List;

public class DiscountProductSection extends ProductSection<DiscountProduct> {
    public DiscountProductSection(By section, By title, By slickPrev, By slickNext) {
        super(section, title, slickPrev, slickNext);
    }

    public List<AbstractProduct> getActiveProduct() {
        return this.getActiveProduct(DiscountProduct.class);
    }

    public List<AbstractProduct> getAllActiveProduct() {
        return this.getAllActiveProduct(DiscountProduct.class);
    }
}