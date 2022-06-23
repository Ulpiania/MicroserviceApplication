package com.tsi.alex.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeliniumTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test() {
        driver.navigate().to("http://localhost:3000/products");

        try {
            Thread.sleep(75*1000);
            driver.findElement(By.className("filmSearch")).click();
            WebElement filmList = driver.findElement(By.className("filmSearch"));
            Actions enter = new Actions(driver);
            enter.sendKeys(Keys.chord(Keys.ENTER)).perform();

            String expected = "Film title: ACADEMY DINOSAUR";

            String actual = driver.findElement(By.className("titleInfo")).getText();

            Assertions.assertEquals(expected, actual);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




   }
}
