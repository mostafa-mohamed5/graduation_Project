package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.*;
import org.example.utils.SlowDown;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private void goToCheckout() throws InterruptedException {

        new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        new InventoryPage(driver).addAllItems();

        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.checkout();
    }

    // ================= VALID =================

    @Test
    public void checkoutValid1() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("Mai", "Mohamed", "12345");

        SlowDown.waitForStep();

        test.pass("Checkout success");
    }

    @Test
    public void checkoutValid2() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("Mostafa", "Yaser", "12");

        SlowDown.waitForStep();

        test.pass("Checkout success");
    }

    @Test
    public void checkoutValid3() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("Test", "User", "99999");

        SlowDown.waitForStep();

        test.pass("Checkout success");
    }

    @Test
    public void checkoutValid4() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("m", "m", "1");

        SlowDown.waitForStep();

        test.pass("Checkout success");
    }

    @Test
    public void checkoutValid5() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("Mohamed", "Bishr", "123456");

        SlowDown.waitForStep();

        test.pass("Checkout success");
    }

    // ================= INVALID =================

    @Test
    public void checkoutInvalid1() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("   ", "Mohamed", "12345");

        SlowDown.waitForStep();

        boolean error = driver.getPageSource().contains("Error");

        checkpoint("checkout_empty_firstname", error);
    }

    @Test
    public void checkoutInvalid2() throws InterruptedException {

        goToCheckout();

        new CheckoutPage(driver)
                .fillInfo("Mostafa", "   ", "12345");

        SlowDown.waitForStep();

        boolean error = driver.getPageSource().contains("Error");

        checkpoint("checkout_empty_lastname", error);
    }
}