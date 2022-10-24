package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.tests.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void createNewStudentTest() {
        new PracticeFormPage(driver).enterPersonalData(
                StudentData.FIRST_NAME,
                StudentData.LAST_NAME,
                StudentData.EMAIL,
                StudentData.MOBIL,
                StudentData.ADDRESS);

        new PracticeFormPage(driver)
                .hideIframes()
                .selectGender(StudentData.GENDER)
                .chooseDate("May", "2021", "15")
                .typeOfDate(StudentData.DATE_OF_BIRTHDAY)
                .addSubject(StudentData.SUBJECT)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY)
                .clickOnSubmit();

        Assert.assertTrue(new PracticeFormPage(driver).submittingForm().contains("Thanks for submitting the form"));

        new PracticeFormPage(driver).closeModalDialog();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingFile")
    public void createNewStudentWithDataProviderTest(String firstName,
                                                     String lastName,
                                                     String email,
                                                     String phone,
                                                     String birthDate,
                                                     String address) {

        new PracticeFormPage(driver).enterPersonalData2(firstName, lastName, email, phone);

        new PracticeFormPage(driver)
                .hideIframes()
                .selectGender(StudentData.GENDER)
                .typeOfDate(birthDate)
                .addSubject(StudentData.SUBJECT)
                .chooseHobby(StudentData.HOBBIES)
                .addAddress(address)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY)
                .clickOnSubmit();

        Assert.assertTrue(new PracticeFormPage(driver).submittingForm().contains("Thanks for submitting the form"));
    }
}
