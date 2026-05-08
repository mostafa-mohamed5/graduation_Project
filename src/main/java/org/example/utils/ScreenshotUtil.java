package org.example.utils;

import org.openqa.selenium.*;

import java.io.File;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {

        String path = "";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            path = System.getProperty("user.dir")
                    + "/screenshots/" + name + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(path);
            dest.getParentFile().mkdirs();

            org.apache.commons.io.FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }

        return path;
    }
}