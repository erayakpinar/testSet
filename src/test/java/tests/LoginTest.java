package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    void invalidLogin(){

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("eray");
        driver.findElement(By.id("password")).sendKeys("eray");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String alert = driver.findElement(By.id("flash")).getText();
        assertTrue(alert.contains("invalid"));
        takeScreenshot("SS-invalidLogin");


    }

    @Test
    void validLogin(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String link = driver.getCurrentUrl();
        assertTrue(link.contains("/secure"));

        String alert = driver.findElement(By.id("flash")).getText();
        assertTrue(alert.contains("secure"));
        takeScreenshot("SS-validLogin");
    }
}
