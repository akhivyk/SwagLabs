package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"test-Username\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"test-Password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-standard_user\"]")
    private ExtendedWebElement selectCredentialsForStandardUserButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-locked_out_user\"]")
    private ExtendedWebElement selectCredentialsForLockedOutUserButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-problem_user\"]")
    private ExtendedWebElement selectCredentialsForProblemUserButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameInputPresent() {
        return usernameInput.isElementPresent(1);
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent(1);
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent(1);
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public void inputUsername(String username) {
        usernameInput.type(username);
    }

    public MainPage clickLogin() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void selectStandardUser() {
        selectCredentialsForStandardUserButton.click();
    }

    public void selectLoggedOutUser() {
        selectCredentialsForLockedOutUserButton.click();
    }

    public void selectProblemUser() {
        selectCredentialsForProblemUserButton.click();
    }
}
