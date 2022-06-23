package com.tsi.alex.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class navigateSeliniumTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void test() {
        driver.navigate().to("http://localhost:3000/");
        try {
            Thread.sleep(5*1000);
            driver.findElement(By.className("filmButton")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            String expected = "http://localhost:3000/products";

            String actual = driver.getCurrentUrl();
            System.out.println(expected);
            System.out.println(actual);
            Assertions.assertEquals(expected, actual);

            driver.quit();


    }
}
