package com.telran.tests;

import com.telran.JSExecutor;
import com.telran.data.TextBoxData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JSTests extends TestBase{

    @Test
    public void typeAndClickWithJSTest(){
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver)
                .enterDataWithJS(TextBoxData.NAME, TextBoxData.EMAIL, TextBoxData.CURRENT_ADDRESS, TextBoxData.PERMANENT_ADDRESS)
                .clickOnSubmitWithJS();
    }

    @Test
    public void checkBoxWithJS(){
        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
        new JSExecutor(driver).checkBoxWithJS().getTitlePageAndUrlWithJS();
    }
}
