package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest extends BaseTest {

    @Test
    public void formDoldur() {

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieChoiceDismiss")));
            cookieBtn.click();
        } catch (Exception ignored) {}


        driver.findElement(By.name("firstname")).sendKeys("Eray");
        driver.findElement(By.name("lastname")).sendKeys("Akpinar");
        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-0")).click();
        driver.findElement(By.id("datepicker")).sendKeys("28-08-2025");
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();


        WebElement continentsDropdown = driver.findElement(By.id("continents"));
        continentsDropdown.findElement(By.xpath("//option[. = 'Europe']")).click();

        WebElement commandsDropdown = driver.findElement(By.id("selenium_commands"));
        commandsDropdown.findElement(By.xpath("//option[. = 'Navigation Commands']")).click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");

        WebElement uploadInput = driver.findElement(By.id("photo"));
        String filePath = System.getProperty("user.dir") + "\\images.jpg"; // images.png proje kökünde olmalı
        uploadInput.sendKeys(filePath);

        driver.findElement(By.id("submit")).click();
    }
}
