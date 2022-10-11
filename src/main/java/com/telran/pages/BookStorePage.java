package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends HomePage{

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton(){
        click(loginButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchBookInput(String bookName){
        type(searchInput, bookName);
        return this;
    }

    @FindBy(css = ".mr-2")
    WebElement nameOfBook;

    public String takeNameOfBook(String bookName){
        return nameOfBook.getText();
    }
}
