package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

    void validLogin(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        takeScreenshot("SS-sDLogin");
    }

    void addToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).isDisplayed();
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).isDisplayed();
        driver.findElement(By.id("checkout")).click();
        takeScreenshot("SS-sDCart");
    }

    void checkout(){
        driver.findElement(By.id("first-name")).sendKeys("Eray");
        driver.findElement(By.id("last-name")).sendKeys("Akpinar");
        driver.findElement(By.id("postal-code")).sendKeys("34000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        takeScreenshot("SS-sDCheckout");
    }

    @Test
    void validTest(){
        validLogin();
        addToCart();
        checkout();
    }

}
