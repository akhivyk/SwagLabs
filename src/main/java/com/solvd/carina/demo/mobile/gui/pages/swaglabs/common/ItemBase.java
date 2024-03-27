package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ItemBase extends AbstractUIObject {
    public ItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ItemPageBase clickOnName();

    public abstract String getElementName();

    public abstract String getTextFromAddToCartButton();

    public abstract String getTextFromRemoveButton();

    public abstract void clickAddToCartButton();
}