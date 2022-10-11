package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Book Store Application']")
    WebElement bookStoreAppTitle;

    public BookStorePage selectBookStoreApp(){
        clickWithJSExecutor(bookStoreAppTitle, 0, 800);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[3]")
    WebElement alertsFrameWindows;

    public SidePanelPage selectAlertsFrameWindows(){
        clickWithJSExecutor(alertsFrameWindows, 0, 300);
        return new SidePanelPage(driver);
    }
}
