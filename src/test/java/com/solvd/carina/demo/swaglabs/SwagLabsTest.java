package com.solvd.carina.demo.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.swaglabs.LoginUtil;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.UserType;
import com.solvd.carina.demo.mobile.gui.pages.swaglabs.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SwagLabsTest implements IAbstractTest, IMobileUtils {

    @Test
    public void loginWithValidCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "PRODUCTS";

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        softAssert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        softAssert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.selectUser(UserType.STANDARD_USER);
        MainPageBase mainPage = loginPage.clickLoginButton();

        softAssert.assertTrue(mainPage.isTitlePresent(), "Title on main page isn't present!");
        softAssert.assertEquals(mainPage.getTitleText(), expectedTitle, "Title on main page isn't equals to expected.");

        softAssert.assertFalse(mainPage.isItemsListEmpty(), "Items list is empty.");

        softAssert.assertAll();
    }

    @Test
    public void verifyItemPage() {
        MainPageBase mainPage = new LoginUtil(getDriver()).loginWithStandardUser();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String nameOfSelectedItem = "Sauce Labs Backpack";
        String expectedDescription = "Sauce Labs Backpack carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String expectedPrice = "$29.99";

        ItemPageBase itemPage = mainPage.clickOnItem(nameOfSelectedItem);

        softAssert.assertTrue(itemPage.isItemPicturePresent(), "Item picture isn't present!");
        softAssert.assertTrue(itemPage.isItemDescriptionPresent(), "Item description isn't present!");
        softAssert.assertTrue(itemPage.isItemPricePresent(), "Item price isn't present!");

        if (getDevice().getDeviceType() == DeviceType.Type.IOS_PHONE) {
            softAssert.assertEquals(itemPage.getItemDescriptionText(), expectedDescription, "Description isn't equals to expected!");
        }
        softAssert.assertEquals(itemPage.getItemPriceText(), expectedPrice, "Price isn't equals to expected!");

        softAssert.assertAll();
    }

    @Test
    public void textChangesOnClickingCartButton() {
        MainPageBase mainPage = new LoginUtil(getDriver()).loginWithStandardUser();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String itemName = "Sauce Labs Backpack";
        String expectedTextOnAddToCartButtonBeforeClicking = "ADD TO CART";
        String expectedTextOnAddToCartButtonAfterClicking = "REMOVE";

        ItemBase item = mainPage.findItemOnPage(itemName);
        softAssert.assertEquals(item.getTextFromAddToCartButton(), expectedTextOnAddToCartButtonBeforeClicking, "Text on " +
                "add to cart button isn't equals to expected before clicking!");

        item.clickAddToCartButton();
        softAssert.assertEquals(item.getTextFromRemoveButton(), expectedTextOnAddToCartButtonAfterClicking, "Text on " +
                "add to cart button isn't equals to expected after clicking!");
        softAssert.assertEquals(mainPage.getCountOfItemInCart(), "1", "Count of items in cart isn't " +
                "equals to expected after adding to cart!");

        softAssert.assertAll();
    }

    @Test
    public void verifyUserCanMakeOrder() {
        MainPageBase mainPage = new LoginUtil(getDriver()).loginWithStandardUser();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String itemName = "Sauce Labs Backpack";

        ItemPageBase itemPage = mainPage.clickOnItem(itemName);
        String expectedDescription = itemPage.getItemDescriptionText();
        String expectedPrice = itemPage.getItemPriceText();

        itemPage.addToCart();
        mainPage = itemPage.backToAllProducts();
        CartPageBase cartPage = mainPage.clickCartButton();

        softAssert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CartItemBase cartItem = cartPage.getItem(expectedDescription);
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
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.STANDARD_USER);
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
