package com.tsi.alex.program;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeliniumTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test() {
        driver.navigate().to("http://localhost:3000/services");

        driver.findElement(By.id("btnActor")).click();
 git a   }
}
