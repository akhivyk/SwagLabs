package com.solvd.carina.demo.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.*;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.CartItem;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.components.Item;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SwagLabsIOSTest implements IAbstractTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    public void login() {
        loginPage = new LoginPage(getDriver());

        loginPage.selectStandardUser();
        mainPage = loginPage.clickLogin();
    }

    @Test
    public void loginWithValidCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "PRODUCTS";

        LoginPage loginPage = new LoginPage(getDriver());

        softAssert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.selectStandardUser();
        MainPage mainPage = loginPage.clickLogin();

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

        ItemPage itemPage = mainPage.openItemPage(nameOfSelectedItem);

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

        ItemPage itemPage = mainPage.openItemPage(itemName);
        String expectedDescription = itemPage.getItemDescriptionText();
        String expectedPrice = itemPage.getItemPriceText();

        itemPage.addToCart();
        mainPage = itemPage.backToAllProducts();
        CartPage cartPage = mainPage.openCartPage();

        softAssert.assertFalse(cartPage.getCartItems().isEmpty(), "Cart is empty.");
        softAssert.assertEquals(cartPage.getCartItems().size(), 1, "Count items in cart isn't equals to expected!");

        CartItem cartItem = cartPage.findItem(expectedDescription);
        softAssert.assertEquals(cartItem.getTextFromPrice(), expectedPrice, "Price in cart isn't equals to expected");

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        softAssert.assertTrue(checkoutPage.isFNameInputPresent(), "First name input isn't present on checkout page!");
        softAssert.assertTrue(checkoutPage.isLNamePresent(), "Last name input isn't present on checkout page!");
        softAssert.assertTrue(checkoutPage.isZipCodeInputPresent(), "Zip code input isn't present on checkout page!");

        checkoutPage.inputFName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLName(R.TESTDATA.get("swagLabs_lName"));
        checkoutPage.inputLName(R.TESTDATA.get("swagLabs_zipCode"));
        OverviewPage overviewPage = checkoutPage.goToTheNextPage();

        CompletedOrderPage completedOrderPage = overviewPage.createOrder();
        softAssert.assertTrue(completedOrderPage.isOrderComplete(), "Order isn't create successfully");

        softAssert.assertAll();
    }

    @Test
    public void verifyUserCanLogout() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.selectStandardUser();
        MainPage mainPage = loginPage.clickLogin();

        MenuPage menu = mainPage.openMenu();
        softAssert.assertTrue(menu.isLogoutButtonPresent(), "Logout button isn't present in menu!");

        loginPage = menu.logout();
        softAssert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present - user isn't back to login page after logging out");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present - user isn't back to login page after logging out");
        softAssert.assertTrue(loginPage.isLoginButtonPresent(), "Login button isn't present - user isn't back to login page after logging out");

        softAssert.assertAll();
    }
}
