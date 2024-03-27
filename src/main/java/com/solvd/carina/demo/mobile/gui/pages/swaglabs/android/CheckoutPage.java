package com.solvd.carina.demo.mobile.gui.pages.swaglabs.android;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    private ExtendedWebElement zipCodeInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstNameInputPresent() {
        return firstNameInput.isElementPresent();
    }

    public boolean isLastNamePresent() {
        return lastNameInput.isElementPresent();
    }

    public boolean isZipCodeInputPresent() {
        return zipCodeInput.isElementPresent();
    }

    public OverviewPageBase clickContinueButton() {
        continueButton.click();
        return initPage(getDriver(), OverviewPageBase.class);
    }

    public void inputFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.type(zipCode);
    }
}
