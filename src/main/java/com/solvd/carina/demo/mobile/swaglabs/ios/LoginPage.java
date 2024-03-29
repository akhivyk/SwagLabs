package com.solvd.carina.demo.mobile.swaglabs.ios;

import com.solvd.carina.demo.mobile.swaglabs.common.LoginPageBase;
import com.solvd.carina.demo.mobile.swaglabs.common.MainPageBase;
import com.solvd.carina.demo.mobile.swaglabs.enums.UserType;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Username\"`]")
    private ExtendedWebElement usernameInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextField[`name == \"test-Password\"`]")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-LOGIN\"`]")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-%s\"`]")
    private ExtendedWebElement selectUserCredentialsButton;

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

    public void selectUser(UserType userType) {
        selectUserCredentialsButton.format(userType.getUsername()).click();
    }
}