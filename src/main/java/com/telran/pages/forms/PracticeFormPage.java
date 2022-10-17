package com.telran.pages.forms;

import com.telran.data.StudentData;
import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            male.click();
        } else if (gender.equals("Female")) {
            female.click();
        } else {
            other.click();
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    public PracticeFormPage typeOfDate(String date) {

        click(dateOfBirth);

        String os = System.getProperty("os.name");

        if (os.startsWith("Mac")) {
            dateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {

        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                typeWithJSExecutor(subjectsInput, subjects[i], 0, 300);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }

        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path){
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterPersonalData(String name, String surname, String email, String mobil, String address){
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        userEmail.sendKeys(email);
        userNumber.sendKeys(mobil);
        currentAddress.sendKeys(address);
        return this;
    }

    @FindBy(id = "state")
    WebElement state;

    public PracticeFormPage enterState(String stateInput){
        typeWithJSExecutor(state, stateInput, 0, 300);
        state.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement city;

    public PracticeFormPage enterCity(String cityInput){
        typeWithJSExecutor(city, cityInput, 0, 300);
        city.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage clickOnSubmit(){
        clickWithJSExecutor(submit, 0, 300);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement subForm;

    public String submittingForm(){
        return subForm.getText();
    }
}
