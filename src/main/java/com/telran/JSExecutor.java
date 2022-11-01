package com.telran;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage {

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJS(String name, String email, String currentAdr, String permanentAdr){
        if(name != null && email != null && currentAdr != null && permanentAdr != null){
            js.executeScript("document.getElementById('userName').value='" + name + "';");
            js.executeScript("document.getElementById('userName').style.border='3px solid red';");
            js.executeScript("document.getElementById('userEmail').value='" + email + "';");
            js.executeScript("document.getElementById('currentAddress').value='" + currentAdr + "';");
            js.executeScript("document.getElementById('permanentAddress').value='" + permanentAdr + "';");
        }
        return this;
    }

    public JSExecutor clickOnSubmitWithJS(){
        js.executeScript("document.getElementById('submit').style.backgroundColor='red'");
        js.executeScript("document.getElementById('submit').click()");
        return this;
    }

    public JSExecutor checkBoxWithJS(){
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }

    public JSExecutor getTitlePageAndUrlWithJS(){
        System.out.println(js.executeScript("return document.title;").toString());
        System.out.println(js.executeScript("return document.URL;").toString());
        return this;
    }
}
