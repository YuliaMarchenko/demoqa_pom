package com.telran.tests.elements;

import com.telran.data.TextBoxData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingFileTestBox")
    public void fillAllDataWithDataProviderTest(String name, String email, String currentAdr, String permanentAdr) {
        new TextBoxPage(driver).fillAllData(name, email, currentAdr, permanentAdr).clickOnSubmit();
        Assert.assertTrue(new TextBoxPage(driver).submittingForm().contains("Name:"));
    }

    @Test
    public void fillAllDataTest() {
        new TextBoxPage(driver).fillAllData(TextBoxData.NAME, TextBoxData.EMAIL, TextBoxData.CURRENT_ADDRESS, TextBoxData.PERMANENT_ADDRESS).clickOnSubmit();
        Assert.assertTrue(new TextBoxPage(driver).submittingForm().contains("Name:"));
    }
}
