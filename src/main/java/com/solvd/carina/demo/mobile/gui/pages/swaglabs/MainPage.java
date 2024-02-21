package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MainPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.Item;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class MainPage extends MainPageBase {
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
    private ExtendedWebElement titleLabel;

    @FindBy(name = "test-Item")
    private List<Item> items;

    @FindBy(name = "test-Menu")
    private ExtendedWebElement menuButton;

    @FindBy(name = "test-Cart")
    private ExtendedWebElement cartButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return titleLabel.isElementPresent();
    }

    public String getTitleText() {
        return titleLabel.getText();
    }

    public boolean isItemsListEmpty() {
        return items.isEmpty();
    }

    public ItemPage clickOnItem(String itemName) {
        return items.stream()
                .filter(item -> itemName.equals(item.getName()))
                .findFirst()
                .map(Item::clickOnName)
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public Item findItemOnPage(String itemName) {
        return items.stream()
                .filter(item -> itemName.equals(item.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public MenuPageBase clickMenuButton() {
        int x = (int) (menuButton.getLocation().getX() + menuButton.getSize().getWidth() * 0.54);
        int y = (int) (menuButton.getLocation().getY() + menuButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return new MenuPage(driver);
    }

    public String getCountOfItemInCart() {
        return cartButton.getAttribute("label");
    }

    public CartPage clickCartButton() {
        int x = (int) (cartButton.getLocation().getX() + cartButton.getSize().getWidth() * 0.54);
        int y = (int) (cartButton.getLocation().getY() + cartButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return new CartPage(driver);
    }

}
