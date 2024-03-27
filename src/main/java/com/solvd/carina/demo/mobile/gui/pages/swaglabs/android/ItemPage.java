package com.solvd.carina.demo.mobile.gui.pages.swaglabs.android;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.ItemPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Image Container\"]")
    private ExtendedWebElement itemPicture;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]")
    private ExtendedWebElement backToAllProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[2]")
    private ExtendedWebElement subtitleLabel;

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
        return subtitleLabel.getText();
    }

    public String getItemPriceText() {
        return itemPrice.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public MainPageBase backToAllProducts() {
        backToAllProductsButton.click();
        return initPage(getDriver(), MainPageBase.class);
    }
}