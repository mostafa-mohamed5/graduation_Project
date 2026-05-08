package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.utils.SlowDown;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void valid1() throws InterruptedException {

        test.info("Valid login test");

        new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        SlowDown.waitForStep();

        test.pass("Login success");
    }

    @Test
    public void valid2() throws InterruptedException {

        new LoginPage(driver)
                .login("locked_out_user", "secret_sauce");

        SlowDown.waitForStep();

        test.pass("Login executed");
    }

    @Test
    public void valid3() throws InterruptedException {

        new LoginPage(driver)
                .login("problem_user", "secret_sauce");

        SlowDown.waitForStep();

        test.pass("Login executed");
    }

    @Test
    public void valid4() throws InterruptedException {

        new LoginPage(driver)
                .login("error_user", "secret_sauce");

        SlowDown.waitForStep();

        test.pass("Login executed");
    }

    @Test
    public void valid5() throws InterruptedException {

        new LoginPage(driver)
                .login("visual_user", "secret_sauce");

        SlowDown.waitForStep();

        test.pass("Login executed");
    }

    // ================= INVALID =================

    @Test
    public void invalid1() throws InterruptedException {

        new LoginPage(driver)
                .login("secret_sauce", "   ");

        SlowDown.waitForStep();

        boolean error = driver.getPageSource().contains("Epic sadface");

        checkpoint("login_empty_password", error);
    }

    @Test
    public void invalid2() throws InterruptedException {

        new LoginPage(driver)
                .login("   ", "standard_user");

        SlowDown.waitForStep();

        boolean error = driver.getPageSource().contains("Epic sadface");

        checkpoint("login_empty_username", error);
    }
}