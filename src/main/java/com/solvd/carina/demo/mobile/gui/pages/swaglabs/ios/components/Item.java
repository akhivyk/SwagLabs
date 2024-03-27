package com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios.components;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.ItemBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import groovy.transform.ToString;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@ToString
public class Item extends ItemBase implements ICustomTypePageFactory {
    @FindBy(name = "test-Item title")
    private ExtendedWebElement name;

    @FindBy(name = "test-Price")
    private ExtendedWebElement price;

    @FindBy(name = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @FindBy(name = "test-REMOVE")
    private ExtendedWebElement removeFromCartButton;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ItemPageBase clickOnName() {
        name.click();
        return initPage(getDriver(), ItemPageBase.class);
    }

    public String getElementName() {
        return name.getText();
    }

    public String getTextFromAddToCartButton() {
        return addToCartButton.getText();
    }

    public String getTextFromRemoveButton() {
        return removeFromCartButton.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
