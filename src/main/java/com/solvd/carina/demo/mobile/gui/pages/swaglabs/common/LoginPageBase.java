package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isUsernameInputPresent();

    public abstract boolean isPasswordInputPresent();

    public abstract boolean isLoginButtonPresent();

    public abstract void inputPassword(String password);

    public abstract void inputUsername(String username);

    public abstract MainPageBase clickLoginButton();

    public abstract void selectStandardUser();

    public abstract void selectLoggedOutUser();

    public abstract void selectProblemUser();
}
