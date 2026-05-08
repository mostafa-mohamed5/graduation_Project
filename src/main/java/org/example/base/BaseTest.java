package org.example.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.ExtentManager;
import org.example.utils.SlowDown;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    // ================= SETUP =================
    @BeforeMethod
    public void setUp() {

        extent = ExtentManager.getInstance();
        test = extent.createTest(getClass().getSimpleName());

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        SlowDown.waitForStep();
    }

    // ================= CHECKPOINT METHOD =================
    public void checkpoint(String name, boolean condition) {

        String path = ScreenshotUtil.takeScreenshot(driver, name);

        if (condition) {
            test.pass("Checkpoint Passed: " + name)
                    .addScreenCaptureFromPath(path);
        } else {
            test.fail("Checkpoint Failed: " + name)
                    .addScreenCaptureFromPath(path);
        }
    }

    // ================= TEARDOWN =================
    @AfterMethod
    public void tearDown(ITestResult result) {

        try {

            // ❌ FAILURE
            if (result.getStatus() == ITestResult.FAILURE) {

                String path = ScreenshotUtil.takeScreenshot(driver, result.getName());

                test.fail(result.getThrowable())
                        .addScreenCaptureFromPath(path);
            }

            // ✅ SUCCESS
            else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed Successfully");
            }

            // ⏳ SKIP (optional handling)
            else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("Test Skipped");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        SlowDown.waitForStep();

        if (driver != null) {
            driver.quit();
        }
    }

    // ================= FLUSH REPORT =================
    @AfterSuite
    public void flushReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}