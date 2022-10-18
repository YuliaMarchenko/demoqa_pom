package com.telran.pages.interactions;

import com.telran.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends HomePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe(){

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        if(dropHere.getText().equals("Dropped!")){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        return this;
    }

    public DragAndDropPage dragAndDropBy(){
        Actions actions = new Actions(driver);

        int xOffSet = dragMe.getLocation().getX();
        int yOffSet = dragMe.getLocation().getY();
        System.out.println("xOffSet: " + xOffSet + "yOffSet: " + yOffSet);

        int xOffSetTo = dropHere.getLocation().getX();
        int yOffSetTo = dropHere.getLocation().getY();
        System.out.println("xOffSetTo: " + xOffSetTo + "yOffSetTo: " + yOffSetTo);

        xOffSetTo = (xOffSetTo - xOffSet) + 50;
        yOffSetTo = (yOffSetTo - yOffSet) + 100;

        actions.dragAndDropBy(dragMe, xOffSetTo, yOffSetTo).perform();

        if(dropHere.getText().equals("Dropped!")){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        return this;
    }
}
