package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OverviewPageBase extends AbstractPage {
    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CompletedOrderPageBase clickFinishButton();
}
