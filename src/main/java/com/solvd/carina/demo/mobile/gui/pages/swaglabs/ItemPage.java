package com.solvd.carina.demo.mobile.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {
    @FindBy(name = "test-Image Container")
    private ExtendedWebElement itemPicture;

    @FindBy(name = "test-Description")
    private ExtendedWebElement itemDescription;

    @FindBy(name = "test-Price")
    private ExtendedWebElement itemPrice;

    @FindBy(name = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @FindBy(name = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToAllProductsButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemPicturePresent() {
        return itemPicture.isElementPresent(1);
    }

    public boolean isItemDescriptionPresent() {
        return itemDescription.isPresent(1);
    }

    public boolean isItemPricePresent() {
        return itemPrice.isElementPresent(1);
    }

    public String getItemDescriptionText() {
        return itemDescription.getText();
    }

    public String getItemPriceText() {
        return itemPrice.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public MainPage backToAllProducts() {
        backToAllProductsButton.click();
        return new MainPage(driver);
    }
}
