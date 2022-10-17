package com.telran.tests;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Test start " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Passed: " + result.getMethod().getMethodName());
        } else {
            logger.error("Failed: " + result.getMethod().getMethodName());
            new BasePage(driver).takeScreenshot();
        }
    }
}
