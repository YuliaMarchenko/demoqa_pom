package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames(){
        int countIframes = iframes.size();
        System.out.println("Count of iframe " + countIframes);
        driver.switchTo().frame(frame1);
        int countIframesInFrame1 = iframes.size();
        System.out.println("Count of iframe in frame1 " + countIframesInFrame1);
        driver.switchTo().frame(0);
        System.out.println("Frame2 is " + body.getText());
        return this;
    }

    public String isChildFrameTextPresent(){
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(0);
        return body.getText();
    }

    public NestedFramesPage switchToParentFrame(){
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        System.out.println(body.getText());
        return this;
    }
}
