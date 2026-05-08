package org.example.tests;

import org.example.base.BaseTest;
import org.example.utils.SlowDown;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LogoutTest extends BaseTest {

    @Test
    public void logout() throws InterruptedException {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        SlowDown.waitForStep();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);

        SlowDown.waitForStep();

        test.pass("Logout success");
    }
}