package com.solvd.carina.demo.mobile.gui.pages.swaglabs.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {
    @FindBy(name = "test-Description")
    private ExtendedWebElement description;

    @FindBy(name = "test-Price")
    private ExtendedWebElement price;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTextFromDescription() {
        return description.getAttribute("label");
    }

    public String getTextFromPrice() {
        return price.getText().replaceAll("REMOVE", "").trim();
    }
}
