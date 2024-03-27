package com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios.components.CartItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(name = "test-Item")
    private List<CartItem> cartItems;

    @FindBy(name = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartItem getItem(String itemDesc) {
        return cartItems.stream()
                .filter(item -> itemDesc.equals(item.getTextFromDescription()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cart item not found: " + itemDesc));
    }

    public boolean isCartListEmpty() {
        return cartItems.isEmpty();
    }

    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
