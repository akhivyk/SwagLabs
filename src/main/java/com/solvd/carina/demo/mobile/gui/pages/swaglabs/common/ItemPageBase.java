package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ItemPageBase extends AbstractPage {
    public ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isItemPicturePresent();

    public abstract boolean isItemDescriptionPresent();

    public abstract boolean isItemPricePresent();

    public abstract String getItemDescriptionText();

    public abstract String getItemPriceText();

    public abstract void addToCart();

    public abstract MainPageBase backToAllProducts();
}
