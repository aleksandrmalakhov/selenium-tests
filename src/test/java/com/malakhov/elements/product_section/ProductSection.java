package com.malakhov.elements.product_section;

import com.malakhov.AbstractElement;
import com.malakhov.elements.product.AbstractProduct;
import com.malakhov.elements.product.NewProduct;
import com.malakhov.elements.product.Product;
import com.malakhov.elements.product.DiscountProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ProductSection<T extends Product> extends AbstractElement {
    private final By section;
    private final By title;
    private final By slickPrev;
    private final By slickNext;

    public ProductSection(By section, By title, By slickPrev, By slickNext) {
        this.section = section;
        this.title = title;
        this.slickPrev = slickPrev;
        this.slickNext = slickNext;
    }

    public String getTitle() {
        return findElement(section).findElement(title).getText();
    }

    public void slickPrev() {
        slick(slickPrev);
    }

    public void slickNext() {
        slick(slickNext);
    }

    private void slick(By locator) {
        var slick = findElement(section).findElement(locator);
        actions.moveToElement(slick)
                .click()
                .pause(Duration.ofSeconds(1))
                .perform();
    }

    protected List<WebElement> getProductWebElements() {
        var currentSection = findElement(section);
        actions.scrollToElement(currentSection).perform();
        return currentSection.findElements(By.cssSelector(".slick-track .slick-active"));
    }

    protected List<AbstractProduct> getActiveProduct(Class<T> clazz) {
        return getProductWebElements().stream()
                .map(element -> {
                    actions.moveToElement(element).perform();
                    wait.until(ExpectedConditions.visibilityOf(element));
                    if (clazz.getSimpleName().equals(DiscountProduct.class.getSimpleName())) {
                        return new DiscountProduct(element);
                    } else if (clazz.getSimpleName().equals(NewProduct.class.getSimpleName())) {
                        return new NewProduct(element);
                    }
                    throw new IllegalArgumentException("");
                })
                .collect(Collectors.toList());
    }

    protected List<AbstractProduct> getAllActiveProduct(Class<T> clazz) {
        List<AbstractProduct> listProduct = this.getActiveProduct(clazz);
        var subProduct = listProduct.get(listProduct.size() - 1);

        List<AbstractProduct> subList;
        while (subProduct != null) {
            this.slickPrev();
            subList = this.getActiveProduct(clazz);
            var firstProduct = subList.get(0);

            if (firstProduct.getTitle().equals(subProduct.getTitle())) {
                subProduct = null;
            } else {
                listProduct.add(firstProduct);
            }
        }
        return listProduct;
    }
}