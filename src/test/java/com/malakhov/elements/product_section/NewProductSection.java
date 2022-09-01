package com.malakhov.elements.product_section;

import com.malakhov.elements.product.AbstractProduct;
import com.malakhov.elements.product.NewProduct;
import org.openqa.selenium.By;

import java.util.List;

public class NewProductSection extends ProductSection<NewProduct> {
    public NewProductSection(By section, By title, By slickPrev, By slickNext) {
        super(section, title, slickPrev, slickNext);
    }

    public List<AbstractProduct> getActiveProduct() {
        return this.getActiveProduct(NewProduct.class);
    }

    public List<AbstractProduct> getAllActiveProduct() {
        return this.getAllActiveProduct(NewProduct.class);
    }
}
