package com.solvd.carina.demo.mobile.gui.pages.swaglabs.android;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CompletedOrderPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private ExtendedWebElement finishButton;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPageBase clickFinishButton() {
        swipe(finishButton, 2);

        finishButton.click();
        return initPage(getDriver(), CompletedOrderPageBase.class);
    }
}
