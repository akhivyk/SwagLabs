package com.solvd.carina.demo.mobile.gui.pages.swaglabs.components;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.ItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import groovy.transform.ToString;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@ToString
public class Item extends AbstractUIObject {
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

    public ItemPage clickOnName() {
        name.click();
        return new ItemPage(driver);
    }

    public String getName() {
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
