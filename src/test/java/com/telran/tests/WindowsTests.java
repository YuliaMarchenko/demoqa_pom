package com.telran.tests;

import com.telran.pages.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest(){
        new BrowserWindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }
}
