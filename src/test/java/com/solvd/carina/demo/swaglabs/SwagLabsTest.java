package com.solvd.carina.demo.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.*;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.*;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.CartItem;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.Item;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SwagLabsTest implements IAbstractTest {
    private LoginPageBase loginPage;
    private MainPageBase mainPage;

    public void login() {
        loginPage = new LoginPage(getDriver());

        loginPage.selectStandardUser();
        mainPage = loginPage.clickLoginButton();
    }

    @Test
    public void loginWithValidCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "PRODUCTS";

        LoginPageBase loginPage = new LoginPage(getDriver());

        softAssert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.selectStandardUser();
        MainPageBase mainPage = loginPage.clickLoginButton();

        softAssert.assertTrue(mainPage.isTitlePresent(), "Title on main page isn't present!");
        softAssert.assertEquals(mainPage.getTitleText(), expectedTitle, "Title on main page isn't equals to expected.");

        softAssert.assertFalse(mainPage.isItemsListEmpty(), "Items list is empty.");

        softAssert.assertAll();
    }

    @Test
    public void verifyItemPage() {
        login();
        SoftAssert softAssert = new SoftAssert();

        String nameOfSelectedItem = "Sauce Labs Fleece Jacket";
        String expectedDescription = "Sauce Labs Fleece Jacket It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        String expectedPrice = "$49.99";

        ItemPageBase itemPage = mainPage.clickOnItem(nameOfSelectedItem);

        softAssert.assertTrue(itemPage.isItemPicturePresent(), "Item picture isn't present!");
        softAssert.assertTrue(itemPage.isItemDescriptionPresent(), "Item description isn't present!");
        softAssert.assertTrue(itemPage.isItemPricePresent(), "Item price isn't present!");

        softAssert.assertEquals(itemPage.getItemDescriptionText(), expectedDescription, "Description isn't equals to expected!");
        softAssert.assertEquals(itemPage.getItemPriceText(), expectedPrice, "Price isn't equals to expected!");

        softAssert.assertAll();
    }

    @Test
    public void textChangesOnClickingCartButton() {
        login();
        SoftAssert softAssert = new SoftAssert();

        String itemName = "Sauce Labs Bike Light";
        String expectedTextOnAddToCartButtonBeforeClicking = "ADD TO CART";
        String expectedTextOnAddToCartButtonAfterClicking = "REMOVE";

        Item item = mainPage.findItemOnPage(itemName);
        softAssert.assertEquals(item.getTextFromAddToCartButton(), expectedTextOnAddToCartButtonBeforeClicking, "Text on " +
                "add to cart button isn't equals to expected before clicking!");
        softAssert.assertNull(mainPage.getCountOfItemInCart(), "Count of items in cart isn't " +
                "equals to expected before adding item to cart!");

        item.clickAddToCartButton();
        softAssert.assertEquals(item.getTextFromRemoveButton(), expectedTextOnAddToCartButtonAfterClicking, "Text on " +
                "add to cart button isn't equals to expected after clicking!");
        softAssert.assertEquals(mainPage.getCountOfItemInCart(), "1", "Count of items in cart isn't " +
                "equals to expected after adding to cart!");

        softAssert.assertAll();
    }

    @Test
    public void verifyUserCanMakeOrder() {
        login();

        SoftAssert softAssert = new SoftAssert();
        String itemName = "Sauce Labs Backpack";

        ItemPageBase itemPage = mainPage.clickOnItem(itemName);
        String expectedDescription = itemPage.getItemDescriptionText();
        String expectedPrice = itemPage.getItemPriceText();

        itemPage.addToCart();
        mainPage = itemPage.backToAllProducts();
        CartPageBase cartPage = mainPage.clickCartButton();

        softAssert.assertFalse(cartPage.getCartItems().isEmpty(), "Cart is empty.");
        softAssert.assertEquals(cartPage.getCartItems().size(), 1, "Count items in cart isn't equals to expected!");

        CartItem cartItem = cartPage.getItem(expectedDescription);
        softAssert.assertEquals(cartItem.getTextFromPrice(), expectedPrice, "Price in cart isn't equals to expected");

        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        softAssert.assertTrue(checkoutPage.isFirstNameInputPresent(), "First name input isn't present on checkout page!");
        softAssert.assertTrue(checkoutPage.isLastNamePresent(), "Last name input isn't present on checkout page!");
        softAssert.assertTrue(checkoutPage.isZipCodeInputPresent(), "Zip code input isn't present on checkout page!");

        checkoutPage.inputFirstName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLastName(R.TESTDATA.get("swagLabs_lName"));
        checkoutPage.inputZipCode(R.TESTDATA.get("swagLabs_zipCode"));
        OverviewPageBase overviewPage = checkoutPage.clickContinueButton();

        CompletedOrderPageBase completedOrderPage = overviewPage.clickFinishButton();
        softAssert.assertTrue(completedOrderPage.isOrderComplete(), "Order isn't create successfully");

        softAssert.assertAll();
    }

    @Test
    public void verifyUserCanLogout() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = new LoginPage(getDriver());

        loginPage.selectStandardUser();
        MainPageBase mainPage = loginPage.clickLoginButton();

        MenuPageBase menu = mainPage.clickMenuButton();
        softAssert.assertTrue(menu.isLogoutButtonPresent(), "Logout button isn't present in menu!");

        loginPage = menu.clickLogoutButton();
        softAssert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present - user isn't back to login page after logging out");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present - user isn't back to login page after logging out");
        softAssert.assertTrue(loginPage.isLoginButtonPresent(), "Login button isn't present - user isn't back to login page after logging out");

        softAssert.assertAll();
    }
}
