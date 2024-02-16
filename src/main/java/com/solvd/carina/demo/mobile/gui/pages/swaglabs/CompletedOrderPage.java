package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CompletedOrderPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompletedOrderPage extends CompletedOrderPageBase {
    @FindBy(name = "THANK YOU FOR YOU ORDER")
    private ExtendedWebElement completedOrderLabel;

    public CompletedOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderComplete() {
        return completedOrderLabel.isElementPresent();
    }
}
