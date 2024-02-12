package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends AbstractPage implements IMobileUtils {
    @FindBy(name = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public boolean isLogoutButtonPresent() {
        return logoutButton.isElementPresent(1);
    }
}
