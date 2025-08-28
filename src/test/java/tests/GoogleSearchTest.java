package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'Kabul et') or contains(text(),'Accept all')]")
            ));
            acceptBtn.click();
        } catch (Exception ignored) {}

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        String query = "Selenium WebDriver";

        Actions actions = new Actions(driver);

        for (char c : query.toCharArray()) {
            actions.sendKeys(searchBox, String.valueOf(c)).perform();
            Thread.sleep(300);
        }
        actions.sendKeys(Keys.ENTER).perform();


        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        System.out.println("İlk Sonuç Başlığı: " + firstResult.getText());
    }
}
