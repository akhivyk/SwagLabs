package com.solvd.carina.demo.mobile.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickLogoutButton();

    public abstract boolean isLogoutButtonPresent();
}
