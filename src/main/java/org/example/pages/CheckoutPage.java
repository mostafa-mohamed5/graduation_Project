package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInfo(String f, String l, String zip) throws InterruptedException {

        driver.findElement(By.id("first-name")).sendKeys(f);
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys(l);
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        Thread.sleep(2000);

        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();

    }
}