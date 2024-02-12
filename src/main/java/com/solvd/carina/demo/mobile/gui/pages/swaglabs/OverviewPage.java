package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {
    @FindBy(name = "test-FINISH")
    private ExtendedWebElement finishButton;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPage createOrder() {
        finishButton.click();
        return new CompletedOrderPage(driver);
    }
}
