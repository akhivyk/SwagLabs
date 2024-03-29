package com.solvd.carina.demo.mobile.swaglabs.utils;

import com.solvd.carina.demo.mobile.swaglabs.common.LoginPageBase;
import com.solvd.carina.demo.mobile.swaglabs.common.MainPageBase;
import com.solvd.carina.demo.mobile.swaglabs.enums.UserType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginUtil implements ICustomTypePageFactory {

    public MainPageBase loginStandardUser() {
        return login(UserType.STANDARD_USER);
    }

    public MainPageBase login(UserType userType) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);

        loginPage.selectUser(userType);
        return loginPage.clickLoginButton();
    }
}
