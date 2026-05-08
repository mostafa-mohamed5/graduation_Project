package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.SlowDown;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCart() throws InterruptedException {

        new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        SlowDown.waitForStep();

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addAllItems();

        SlowDown.waitForStep();

        test.pass("Items added");
    }
}