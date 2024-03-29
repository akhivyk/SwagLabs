package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.Item;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends AbstractPage implements IMobileUtils {
    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract String getTitleText();

    public abstract boolean isItemsListEmpty();

    public abstract ItemPageBase clickOnItem(String itemName);

    public abstract Item findItemOnPage(String itemName);

    public abstract MenuPageBase clickMenuButton();

    public abstract String getCountOfItemInCart();

    public abstract CartPageBase clickCartButton();
}
