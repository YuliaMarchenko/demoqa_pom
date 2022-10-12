package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClick;

    public ButtonsPage doubleClick(){
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        return this;
    }


    @FindBy(id = "rightClickBtn")
    WebElement rightClick;

    public ButtonsPage rightClick(){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();
        return this;
    }
}
