package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {
    @FindBy(name = "test-First Name")
    private ExtendedWebElement fNameInput;

    @FindBy(name = "test-Last Name")
    private ExtendedWebElement lNameInput;

    @FindBy(name = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeInput;

    @FindBy(name = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillAllRequiredFields() {
        fNameInput.type(R.TESTDATA.get("swagLabs_fName"));
        lNameInput.type(R.TESTDATA.get("swagLabs_lName"));
        zipCodeInput.type(R.TESTDATA.get("swagLabs_zipCode"));
    }

    public boolean isFNameInputPresent() {
        return fNameInput.isElementPresent(1);
    }

    public boolean isLNamePresent() {
        return lNameInput.isElementPresent(1);
    }

    public boolean isZipCodeInputPresent() {
        return zipCodeInput.isElementPresent(1);
    }

    public OverviewPage goToTheNextPage() {
        continueButton.click();
        return new OverviewPage(driver);
    }

    public void inputFName(String fName) {
        fNameInput.type(fName);
    }

    public void inputLName(String lName) {
        lNameInput.type(lName);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.type(zipCode);
    }
}
