package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UploadAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class UploadAndDownloadPageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectUploadAndDownLoad();
    }

    @Test
    public void robotKeyEventTest() throws AWTException {
        new UploadAndDownloadPage(driver).performEventKeyUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("1.pages"));
    }

    @Test
    public void robotMouseEventUsingRobotTest() throws AWTException {
        new UploadAndDownloadPage(driver).performMouseEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("1.pages"));
    }
}
