package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

public enum UserType {
    STANDARD_USER_ANDROID("standard_user"),
    STANDARD_USER_IOS("test-standard_user"),
    LOCKED_OUT_USER_ANDROID("locked_out_user"),
    LOCKED_OUT_USER_IOS("test-locked_out_user"),
    PROBLEM_USER_ANDROID("problem_user"),
    PROBLEM_USER_IOS("test-problem_user");

    private final String username;

    UserType(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
