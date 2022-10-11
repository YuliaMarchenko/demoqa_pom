package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    WebElement buttonLogOut;

    @FindBy(id = "userName-value")
    WebElement textUserName;

    public LoginPage logOut() {
        click(buttonLogOut);
        return new LoginPage(driver);
    }

    public ProfilePage verifyUserName(String userName) {
        if(textUserName.getText().equals(userName)) {
            System.out.println("correct user name " + textUserName.getText());
        }
        return this;
    }

    @FindBy(id = "delete-record-undefined")
    List<WebElement> trashList;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;

    public ProfilePage deleteBook(){
        trashList.get(0).click();
        pause(500);
        click(okButton);
        pause(500);
        acceptAlert();
        return this;
    }
}
