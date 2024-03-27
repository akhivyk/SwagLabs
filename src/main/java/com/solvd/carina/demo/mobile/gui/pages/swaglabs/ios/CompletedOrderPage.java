package com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CompletedOrderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CompletedOrderPageBase.class)
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
