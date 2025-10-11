package com.steps;

import com.pages.CartPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import java.time.Duration;


public class CartSteps {

   WebDriver driver = Hooks.driver;
   LoginPage loginPage;
   DashboardPage dashboardPage;
   CartPage cartPage;

   @Given("user is logged in")
   public void user_is_logged_in() {
//       driver = new ChromeDriver();
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       driver.manage().window().maximize();
//       driver.get("https://www.saucedemo.com/");
       loginPage = new LoginPage(driver);
       loginPage.login("standard_user", "secret_sauce");
   }

   @And("user is on the cart page")
   public void user_is_on_the_cart_page() {
       dashboardPage = new DashboardPage(driver);
       dashboardPage.goToCartPage();
       cartPage = new CartPage(driver);
       assertTrue(cartPage.isCartPageDisplayed());
   }

   @Then("cart page should be displayed")
   public void cart_page_should_be_displayed() {
       assertTrue(cartPage.isCartPageDisplayed());
       driver.quit();
   }

   @And("user has added items to the cart")
   public void user_has_added_items_to_the_cart() {
       dashboardPage = new DashboardPage(driver);
       dashboardPage.addProductToCart();
       dashboardPage.goToCartPage();
       cartPage = new CartPage(driver);
   }

   @When("user clicks on \"Continue Shopping\"")
   public void user_clicks_on_continue_shopping() {
       cartPage.clickContinueShopping();
   }

   @Then("user should be redirected to the products page")
   public void user_should_be_redirected_to_the_products_page() {
       assertTrue(driver.getCurrentUrl().contains("inventory"));
       driver.quit();
   }

   @When("user clicks on \"Checkout\"")
   public void user_clicks_on_Checkout() {
       cartPage.clickCheckout();
   }

   @Then("user should be redirected to the checkout page")
   public void user_should_be_redirected_to_the_checkout_page() {
       assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
       driver.quit();
   }
}