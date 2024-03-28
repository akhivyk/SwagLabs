package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MainPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LoginUtil extends AbstractPage {

    public LoginUtil(WebDriver driver) {
        super(driver);
    }

    public MainPageBase loginWithStandardUser() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.STANDARD_USER);
        return loginPage.clickLoginButton();
    }

    public MainPageBase loginWithLockedOutUser() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.LOCKED_OUT_USER);
        return loginPage.clickLoginButton();
    }

    public MainPageBase loginWithProblemUser() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.PROBLEM_USER);
        return loginPage.clickLoginButton();
    }

    public MainPageBase loginWithUser(UserType userType) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(userType);
        return loginPage.clickLoginButton();
    }
}
