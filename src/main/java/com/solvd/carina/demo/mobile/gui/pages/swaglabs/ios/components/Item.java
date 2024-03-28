package com.solvd.carina.demo.mobile.gui.pages.swaglabs.ios.components;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.ItemPageBase;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.components.ItemBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import groovy.transform.ToString;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@ToString
public class Item extends ItemBase implements ICustomTypePageFactory {

    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement name;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private ExtendedWebElement removeFromCartButton;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ItemPageBase clickOnName() {
        name.click();
        return initPage(ItemPageBase.class);
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
