package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadAndDownloadPage extends BasePage {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadAndDownloadPage performEventKeyUsingRobot() throws AWTException {
        clickWithRectangle(uploadFile, 12,2);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public String getPath(){
        return uploadedFilePath.getText();
    }


    public UploadAndDownloadPage performMouseEventUsingRobot() throws AWTException {
        clickWithRectangle(uploadFile, 12,2);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        Dimension i = driver.manage().window().getSize();
        int x = i.getWidth()/4 + 500;
        int y = i.getHeight()/10 + 150;
        robot.mouseMove(x, y);
        pause(2000);
        //robot.mouseMove(0, 300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(10000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
