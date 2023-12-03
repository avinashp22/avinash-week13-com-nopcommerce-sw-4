package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


@Test
public void verifyUserShouldNavigateToLoginPageSuccessfully(){
    homePage.clickOnLoginLink();
    String expectedText = "Welcome, Please Sign In!";
    String actualText = loginPage.getWelcomeText();
    Assert.assertEquals(actualText, expectedText, "Not redirected to Login page");
}

    @Test
    public void verifyErrorMessageWithInvalidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("Prime321@gmail.com");
        loginPage.enterPassword("Prime321");
        loginPage.clickOnLoginButton();

        String expectedError = "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error Message not Displayed");
}

    @Test
    public void verifyMessageWithValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("Prime123@gmail.com");
        loginPage.enterPassword("Prime123");
        loginPage.clickOnLoginButton();

        String expectedError = "Welcome to our store";
        String actualError = loginPage.getWelcomeMessage(); // //h2[normalize-space()='Welcome to our store']
        Assert.assertEquals(actualError, expectedError, "Error Message not Displayed");

    }



}