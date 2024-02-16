package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.CartItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends CartPageBase {
    @FindBy(name = "test-Item")
    private List<CartItem> cartItems;

    @FindBy(name = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public CartItem getItem(String itemDesc) {
        return cartItems.stream()
                .filter(item -> itemDesc.equals(item.getTextFromDescription()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cart item not found: " + itemDesc));
    }

    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
