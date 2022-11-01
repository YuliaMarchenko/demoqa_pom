package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrokenLinks;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectBrokenLinks();
    }

    @Test
    public void checkBrokenLinksTest(){
        new BrokenLinks(driver).checkAllLinks().checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest(){
        new BrokenLinks(driver).checkBrokenImages();
    }
}
