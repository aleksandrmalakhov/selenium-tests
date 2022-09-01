package com.malakhov.elements.product;

import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public abstract class Product implements AbstractProduct {
    private final WebElement element;
    private final String title;
    private final String shortDesc;
    private final String price;

    public Product(@NonNull WebElement element) {
        this.element = element;
        title = element.findElement(By.tagName("h3")).getText();
        shortDesc = element.findElement(By.tagName("p")).getText();
        price = element.findElement(By.cssSelector(".amount")).getText();
    }

    protected boolean isSale(@NonNull WebElement element) {
        return promoLabel(element, By.className("onsale"), "Скидка!");
    }

    protected boolean isNew(@NonNull WebElement element) {
        return promoLabel(element, By.className("label-new"), "Новый!");
    }

    private boolean promoLabel(@NonNull WebElement element, By locator, String text) {
        var elements = element.findElements(locator);
        if (!elements.isEmpty()) {
            for (WebElement el : elements) {
                if (el.getText().equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}