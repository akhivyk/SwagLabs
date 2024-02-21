package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class MenuPage extends MenuPageBase {
    @FindBy(name = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public boolean isLogoutButtonPresent() {
        return logoutButton.isElementPresent(1);
    }
}
