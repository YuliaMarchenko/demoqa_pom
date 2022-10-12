package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    public FramePage returnListOfFrames(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of frames are " + numberOfFrames);
        System.out.println("Number of frames are " + frames.size());
        return this;
    }

    public FramePage switchToFrameByIndex(int index){
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage switchToFrameById(){
        driver.switchTo().frame(frame1);
        String frameText = this.sampleHeading.getText();
        System.out.println("Text frame: " + frameText);
        driver.switchTo().defaultContent();
        return this;
    }
}
