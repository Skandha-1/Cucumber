package com.steps;

import com.pages.LoginPage;
import com.pages.DashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class DemoLoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user on login page")
    public void user_on_login_page() {
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("entering valid username {string} and password {string}")
    public void entering_valid_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("dashboard page is displayed")
    public void dashboard_page_is_displayed() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("user logs out")
    public void user_logs_out() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();
        driver.quit();
    }

    @When("enter invaild credentials {string} and {string}")
    public void enter_invaild_credentials_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("still in the login page")
    public void still_in_the_login_page() {
        assertTrue(driver.getCurrentUrl().contains("saucedemo"));
        driver.quit();
    }

    @Given("the user is logged into saucedemo")
    public void the_user_is_logged_into_saucedemo() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("the user clicks on the profile icon")
    public void the_user_clicks_on_the_profile_icon() {
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.openMenu();
    }

    @When("selects the logout option")
    public void selects_the_logout_option() {
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.logout();
    }

    @Then("the user should go back to login page")
    public void the_user_should_go_back_to_login_page() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("saucedemo"));
        assertTrue(Hooks.driver.getCurrentUrl().contains("saucedemo"));
    }}