package com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios.components;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartItemBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends CartItemBase {
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
