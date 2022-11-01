package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement slider;

    public SliderPage moveSliderInHorriszontal(){
        Actions actions = new Actions(driver);
        int width = slider.getSize().getWidth();
        actions.moveToElement(slider, width/10,0).click().perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public boolean isSliderDisplayed(int number){
        should(sliderValue, 10);
        return driver.findElement(By.cssSelector("#sliderValue[value='" + number + "']")).isDisplayed();
    }

    public void should(WebElement element, int time){
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }
}
