package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.Item;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends AbstractPage implements IMobileUtils {
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @FindBy(name = "test-Item")
    private List<Item> items;

    @FindBy(name = "test-Menu")
    private ExtendedWebElement menu;

    @FindBy(name = "test-Cart")
    private ExtendedWebElement cartButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    public String getTitleText() {
        return title.getText();
    }

    public boolean isItemsListEmpty() {
        return items.isEmpty();
    }

    public ItemPage openItemPage(String itemName) {
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

    public MenuPage openMenu() {
        int x = (int) (menu.getLocation().getX() + menu.getSize().getWidth() * 0.54);
        int y = (int) (menu.getLocation().getY() + menu.getSize().getHeight() * 0.9);
        tap(x, y);
        return new MenuPage(driver);
    }

    public String getCountOfItemInCart() {
        return cartButton.getAttribute("label");
    }

    public CartPage openCartPage() {
        int x = (int) (cartButton.getLocation().getX() + cartButton.getSize().getWidth() * 0.54);
        int y = (int) (cartButton.getLocation().getY() + cartButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return new CartPage(driver);
    }

}
