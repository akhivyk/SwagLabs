package com.solvd.carina.demo.mobile.gui.pages.swaglabs.android;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"standard_user\"]")
    private ExtendedWebElement selectCredentialsForStandardUserButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"locked_out_user\"]")
    private ExtendedWebElement selectCredentialsForLockedOutUserButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"problem_user\"]")
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

    public MainPageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), MainPageBase.class);
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