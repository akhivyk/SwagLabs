package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CompletedOrderPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.OverviewPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends OverviewPageBase {
    @FindBy(name = "test-FINISH")
    private ExtendedWebElement finishButton;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPageBase clickFinishButton() {
        finishButton.click();
        return new CompletedOrderPage(driver);
    }
}
