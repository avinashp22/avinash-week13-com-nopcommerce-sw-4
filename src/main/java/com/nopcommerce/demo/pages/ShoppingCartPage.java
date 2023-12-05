package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By scText = By.xpath("//h1[contains(text(),'Shopping cart')]");
    By changeQuantity = By.xpath("//input[@aria-label='Qty.']");
    By updateQuantity = By.xpath("//button[@id='updatecart']");
    By total = By.xpath("//span[@class='product-subtotal']");
    By termsOfServiceCheckBox = By.id("//input[@id='termsofservice']");
    By checkOutButton = By.id("checkout");
    By verifyQuantity = By.xpath("//span[contains(text(),'(2)')]");
    By loginLink = By.xpath("//a[text()='Log in']");
    By totalPriceText = By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']");
    By totalPrice = By.xpath("//input[@id='termsofservice']");
    By secondDayAirShippingMethod =  By.cssSelector("li[class='shipping-method'] span[class='value']");

    public String verifyShoppingCartText() {
        return getTextFromElement(scText);
    }

    public String verifyTotalPrice(){
        return getTextFromElement(totalPriceText);
    }

    public String verifyPrice(){
        return getTextFromElement(totalPrice);
    }

    public void updateShoppingCart() {
        driver.findElement(changeQuantity).clear();
        sendTextToElement(changeQuantity, "2");
        clickOnElement(updateQuantity);
    }

    public String getTotalText() {return getTextFromElement(total);}

    public void clickOnTermsOfServiceCheckBox() {clickOnElement(termsOfServiceCheckBox);}

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }

    public String getVerifyQuantity() {
        return getTextFromElement(verifyQuantity);
    }

    public void clickOnLogin() {
        clickOnElement(loginLink);
    }

    public String verifyTotalPriceOfProduct() {return getTextFromElement(totalPriceText);}

    public String verifySecondDayShippingMethod(){
        return getTextFromElement(secondDayAirShippingMethod);
    }

}


