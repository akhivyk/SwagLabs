package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CompletedOrderPageBase extends AbstractPage {

    public CompletedOrderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOrderComplete();
}
