package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest  extends BaseTest {

    HomePage homePage = new HomePage();
    CellPhonePage cellPhonePage = new CellPhonePage();
    NokiaLumia1020Page nokiaLumia1020 = new NokiaLumia1020Page();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();
    LoginPage logIn = new LoginPage();
    RegisterPage register = new RegisterPage();
    CheckoutPage checkout = new CheckoutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //1.1 Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronics();

        //1.2 Mouse Hover on “Cell phones” and click
        homePage.hoverOnCellPhoneAndClick();

        //1.3 Verify the text “Cell phones”
        String actualText = cellPhonePage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Incorrect Text");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronics();

        //2.2 Mouse Hover on “Cell phones” and click
        homePage.hoverOnCellPhoneAndClick();

        //2.3 Verify the text “Cell phones”
        String actualText = cellPhonePage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Incorrect Text");

        //2.4 Click on List View Tab
        cellPhonePage.clickOnListViewTab();

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        cellPhonePage.clickOnNokiaLumia1020();

        //2.6 Verify the text “Nokia Lumia 1020”
        String actualNokiaLumiaText = nokiaLumia1020.getNokiaLumiaText();
        Assert.assertEquals(actualNokiaLumiaText, "Nokia Lumia 1020", "Incorrect Text");

        //2.7 Verify the price “$349.00”
        String actualNokiaPriceText = nokiaLumia1020.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText, "$349.00", "Incorrect Text");

        //2.8 Change quantity to 2
        nokiaLumia1020.changeQuantity();

        //2.9 Click on “ADD TO CART” tab
        nokiaLumia1020.clickOnAddToCartButton();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar  After that close the bar clicking on the cross button.
        String actualTextShoppingCart = nokiaLumia1020.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart, "The product has been added to your shopping cart", "Incorrect Text");
        nokiaLumia1020.closeTheBarByClickingOnTheCrossButton();

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia1020.mouseHoverOnShoppingCart();
        nokiaLumia1020.clickOnShoppingCart();

        // 2.12 Verify the message "Shopping cart"
        String actualShoppingCartMessage = shoppingCart.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage, "Shopping cart", "Incorrect Text");
        Thread.sleep(2000);

        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        String actualQuantity = shoppingCart.getVerifyQuantity();
        Assert.assertEquals(actualQuantity, "(2)", "Incorrect Quantity");

        //2.14 Verify the Total $698.00
        String actualTotal = shoppingCart.getTotalText();
        Assert.assertEquals(actualTotal, "$698.00", "Incorrect Amount");

       // //2.15 click on checkbox “I agree with the terms of service”
        shoppingCart.clickOnTermsOfServiceCheckBox();

        //2.16 Click on “CHECKOUT”
        shoppingCart.clickOnCheckOutButton();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = logIn.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText, "Welcome, Please Sign In!", "Incorrect Text");

        //2.18 Click on “REGISTER” tab
        logIn.clickOnRegisterButton();

        //2.19 Verify the text “Register”
        String actualRegisterText = register.getRegisterText();
        Assert.assertEquals(actualRegisterText, "Register", "Incorrect Text");

        //2.20 Fill the mandatory fields
        register.inputFirstname1("Avinash");
        register.inputLastname1("Patel");
        register.inputEmail1("aavvviinnaassshppaaatttell222000@gmail.comm");
        register.inputPassword("Prime12345!");
        register.inputConfirmPassword("Prime12345!");

        //2.21 Click on “REGISTER” Button
        register.clickOnRegisterButton1();

        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessMessage = register.getRegisterSuccessText();
        Assert.assertEquals(actualRegisterSuccessMessage, "Your registration completed", "Incorrect Text");

        //2.23 Click on “CONTINUE” tab
        register.clickOnContinueButton1();

        //2.24 Verify the text “Shopping cart”
        String actualShoppingCartText = shoppingCart.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartText, "Shopping cart", "Incorrect Text");
        Thread.sleep(2000);

        //after this step cart become empty, so we need to login for next step
        shoppingCart.clickOnLogin();
        logIn.inputEmail("aavvinassshppatttell2200@gmail.com");
        logIn.inputPassword("Prime12345!");
        logIn.clickOnLogin();

        //2.25 click on checkbox “I agree with the terms of service”#
        shoppingCart.clickOnTermsOfServiceCheckBox();

        //2.26 Click on “CHECKOUT”
        shoppingCart.clickOnCheckOutButton();

        //2.27 Fill the Mandatory fields
        //checkout.inputFirstname1("prime123");
        // checkout.inputLastname1("testing");
        // checkout.inputEmail2("prime1236@gmail.com");
        checkout.selectCountry("United Kingdom");
        checkout.inputCity("London");
        checkout.inputAddress("Prime Road");
        checkout.inputPostalCode("NW108EJ");
        checkout.inputPhoneNumber("+447729546859");

        //2.28 Click on “CONTINUE”
        checkout.clickOnContinueButton3();


        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkout.clickOnRadioButton2ndDayAir();

        // 2.30 Click on “CONTINUE”
        checkout.clickOnContinueButton1();

        // 2.31 Select Radio Button “Credit Card”
        checkout.clickOnCreditCard();

        // Click on payment continue
        checkout.clickOnPaymentContinueButton();

        // 2.32 Select “Visa” From Select credit card dropdown
        checkout.selectCreditCard("Visa");

        //2.33 Fill all the details
        checkout.inputCardHolderName("Avinash Patel");
        checkout.inputCardNumber("0000000000000000");
        checkout.selectExpireMonth("12");
        checkout.selectExpireYear("2026");
        checkout.inputCardCode("123");

        //2.34 Click on “CONTINUE” CHECKOUT.
        checkout.clickOnContinueButton2();

        // 2.35 Verify “Payment Method” is “Credit Card”
        String actualCreditCardText = checkout.getCreditCardText();
        Assert.assertEquals(actualCreditCardText, "Credit Card", "Incorrect Text");
        Thread.sleep(2000);

        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualShippingMethodText = checkout.get2DayAirText();
        Assert.assertEquals(actualShippingMethodText, "2nd Day Air", "Incorrect Text");
        Thread.sleep(2000);


        // 2.37 Verify Total is “$698.00”
        String expectedMessage8 = "2nd Day Air";
        String actualMessage8 = shoppingCart.verifySecondDayShippingMethod();
        Assert.assertEquals(actualMessage8, expectedMessage8, "Incorrect Text");
        Thread.sleep(2000);

        // 2.38 Click on “CONFIRM”
        checkout.clickOnConfirmButton();

        //2.39 Verify the Text “Thank You”
        String actualThankYouText = checkout.getThankYouText();
        Assert.assertEquals(actualThankYouText, "Thank you", "Incorrect Text");
        Thread.sleep(2000);

        //2.40 Verify the message “Your order has been successfully processed!”
        String actualSuccessfullyProcessedText = checkout.getOrderSuccessProcessText();
        Assert.assertEquals(actualSuccessfullyProcessedText, "Your order has been successfully processed!", "Incorrect Text");
        Thread.sleep(2000);

        // 2.41 Click on “CONTINUE”
        checkout.clickOnContinueButton4();


        // 2.42 Verify the text “Welcome to our store”
        String actualWelcomeOurStoreText = homePage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeOurStoreText, "Welcome to our store", "Incorrect Text");
        Thread.sleep(2000);

        // 2.43 Click on “Logout” link
        homePage.clickOnLogOutButton();

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo.nopcommerce.com/", "Incorrect Text");
    }

}
