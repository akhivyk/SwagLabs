package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CheckoutPage extends CheckoutPageBase {
    @FindBy(name = "test-First Name")
    private ExtendedWebElement firstNameInput;

    @FindBy(name = "test-Last Name")
    private ExtendedWebElement lastNameInput;

    @FindBy(name = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeInput;

    @FindBy(name = "test-CONTINUE")
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
        return new OverviewPage(driver);
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
