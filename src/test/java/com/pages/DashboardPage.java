package com.pages;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
 
import java.time.Duration;
 
public class DashboardPage {
    WebDriver driver;
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By cartIcon = By.className("shopping_cart_link"); 
    private By productAddButton = By.id("add-to-cart-sauce-labs-backpack"); 
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToCartPage() {
        driver.findElement(cartIcon).click();
    }
    public void addProductToCart() {
        driver.findElement(productAddButton).click();
    }
    public void openMenu() {
        driver.findElement(menuButton).click();
    }
    public void logout() {
        openMenu();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        driver.findElement(logoutLink).click();

    } 
 
}

 