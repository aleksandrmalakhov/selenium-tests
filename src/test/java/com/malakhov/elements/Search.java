package com.malakhov.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BaseElement {
    @FindBy(css = "form.searchform .search-field")
    private WebElement inputField;

    @FindBy(css = "button.searchsubmit")
    private WebElement buttonSearch;

    public Search() {
        super();
    }

    @Step("Set data to search")
    public void setData(String data) {
        inputField.sendKeys(data);
    }

    @Step("Click to button search")
    public void search() {
        buttonSearch.click();
    }
}