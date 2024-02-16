package com.solvd.carina.demo.mobile.gui.pages.swaglabs.common;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.CartItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<CartItem> getCartItems();

    public abstract CartItem getItem(String itemDesc);

    public abstract CheckoutPageBase clickCheckoutButton();
}
