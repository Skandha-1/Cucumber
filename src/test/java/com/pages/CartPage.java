package com.pages;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
 
public class CartPage {

    WebDriver driver;
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
    public boolean isCartPageDisplayed() {

        return driver.getCurrentUrl().contains("cart");

    }

}
 