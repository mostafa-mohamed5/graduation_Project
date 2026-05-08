package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void checkout() {
        driver.findElement(By.id("checkout")).click();
    }
}