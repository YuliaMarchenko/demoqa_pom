package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement slider;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage moveSliderInHorriszontal(){
        Actions actions = new Actions(driver);
      //  actions.moveToElement(slider, 80,0).perform();
       // click(slider);
      //  actions.dragAndDropBy(slider, 20,0).perform();

//        actions.clickAndHold(slider, (-(int)slider.getSize().width / 2), 0).perform();
        return this;
    }

    public String getTestSliderValue(){
        return sliderValue.getText();
    }
}
