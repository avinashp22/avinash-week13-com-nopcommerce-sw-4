package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage logInPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 Click on Computer Menu.
        homePage.selectMenu("Computers");

        //1.2 Click on Desktop
        homePage.clickOnDesktops();

        //get list before filter the name
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.sortByPosition("Name: Z to A");

        //Get list after filter name
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }

        //1.4 Verify the Product will arrange in Descending order.
        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFilterNameZtoAList, afterFilterNameZtoAList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on Computer Menu.
        homePage.selectMenu("Computers");

        //2.2 Click on Desktop
        homePage.clickOnDesktops();

        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.sortByPosition("Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        desktopPage.addToCart();

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = desktopPage.getWelcomeText();
        Assert.assertEquals(actualText, expectedText, "Incorrect Text");

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        desktopPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        // 2.7.Select "8GB [+$60.00]" using Select class.
        desktopPage.selectRam("8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        desktopPage.selectHDDRadio();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        desktopPage.selectOsRadio();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(2000);
        desktopPage.selectSoftware1();
        Thread.sleep(2000);
        desktopPage.selectSoftware3();

        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,420.00";
        String actualPrice = desktopPage.verifyPriceOfBuildYourOwnComputer();
        Assert.assertEquals(actualPrice, expectedPrice, "Incorrect Price");

        //2.12 Click on "ADD TO CARD" Button.
        desktopPage.addToCart1();

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText2 = "The product has been added to your shopping cart";
        String actualText2 = desktopPage.verifyTheMessage();
        Assert.assertEquals(actualText2, expectedText2);

        //After that close the bar clicking on the cross button.
        desktopPage.clickOnClose();


        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        desktopPage.moveToShoppingCart();
        desktopPage.clickOnGoToCart();

        //2.15 Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(expectedText3, actualText3);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.updateShoppingCart();

        //2.17 Verify the Total"$2,950.00
        String expectedPrice1 = "$2,950.00";
       String actualPrice1 = shoppingCartPage.verifyTotalPriceOfProduct();
        Assert.assertEquals(actualPrice1, expectedPrice1, "Incorrect Price");


        // 2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceCheckBox();

        // 2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();

        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeSignInText = logInPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeSignInText, "Welcome, Please Sign In!", "Incorrect Text");

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        logInPage.clickOnCheckoutAsGuestButton();

        //2.22 Fill the all mandatory field
        registerPage.inputFirstname("Avinash");
        registerPage.inputLastname("Patel");
        registerPage.inputEmail("aavvinashppaattell222@gmail.com");
        registerPage.selectCountry("United Kingdom");
        registerPage.inputCity("London");
        registerPage.inputAddress1("Prime Road");
        registerPage.inputPostalCode("NW108EJ");
        registerPage.inputPhoneNumber("+447729546859");

        //2.23 Click on “CONTINUE”
        registerPage.clickOnContinueButton();

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkoutPage.clickOnNextDayAirRadioButton();

        // 2.25 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton1();

        // 2.26 Select Radio Button “Credit Card”
        checkoutPage.clickOnCreditCard();
        checkoutPage.clickOnPaymentContinueButton();

        //2.27 Select “Master card” From Select credit card dropdown
        checkoutPage.selectCreditCard("Master card");

        //2.28 Fill all the details
        checkoutPage.inputCardHolderName("Avinash Patel");
        checkoutPage.inputCardNumber("0000000000000000");
        checkoutPage.selectExpireMonth("12");
        checkoutPage.selectExpireYear("2024");
        checkoutPage.inputCardCode("123");

        // 2.29 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton2();

        //2.30 Verify “Payment Method” is “Credit Card”
        String actualCardMessage = checkoutPage.getCreditCardText();
        Assert.assertEquals(actualCardMessage, "Credit Card", "Incorrect Text");

        // 2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMessage = checkoutPage.getNextDayAirText();
        Assert.assertEquals(actualShippingMessage, "Next Day Air", "Incorrect Text");

        //2.33 Verify Total is “$2,950.00”
        String expectedPrice3 = "$2,950.00";
        String actualPrice3 = shoppingCartPage.verifyTotalPrice();
        Assert.assertEquals(actualPrice3, expectedPrice3, "Incorrect Text");
        Thread.sleep(2000);

        //2.34 Click on “CONFIRM”
        checkoutPage.clickOnConfirmButton();

        // 2.35 Verify the Text “Thank You”
        String actualThankYouText = checkoutPage.getThankYouText();
        Assert.assertEquals(actualThankYouText, "Thank you", "Incorrect Text");

        // 2.36 Verify the message “Your order has been successfully processed!”
        String actualOrderSuccessText = checkoutPage.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessText, "Your order has been successfully processed!", "Incorrect Text");

        // 2.37 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton4();

        // 2.38 Verify the text “Welcome to our store”
        String actualWelcomeStoreText = homePage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeStoreText, "Welcome to our store", "Incorrect Text");

    }
}
