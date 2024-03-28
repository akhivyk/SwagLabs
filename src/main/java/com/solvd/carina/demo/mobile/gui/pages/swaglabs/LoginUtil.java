package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MainPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginUtil implements ICustomTypePageFactory {

    public MainPageBase loginStandardUser() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);

        loginPage.selectUser(UserType.STANDARD_USER);
        return loginPage.clickLoginButton();
    }

    public MainPageBase login(UserType userType) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);

        loginPage.selectUser(userType);
        return loginPage.clickLoginButton();
    }
}
