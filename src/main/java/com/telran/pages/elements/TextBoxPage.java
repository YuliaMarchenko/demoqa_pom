package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage fillAllData(String name, String email, String currentAdr, String permanentAdr){
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        currentAddress.sendKeys(currentAdr);
        permanentAddress.sendKeys(permanentAdr);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage clickOnSubmit() {
        clickWithJSExecutor(submit, 0, 500);
        return this;
    }

    @FindBy(id = "name")
    WebElement subFormName;

    public String submittingForm() {
        return subFormName.getText();
    }
}
