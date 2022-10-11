package com.telran.tests;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookToCollection(){

        new BookStorePage(driver)
                .typeInSearchBookInput(BookData.BOOK_NAME)
                .clickOnBookTitleLink()
                .clickOnAddBookButton()
                .acceptAlert();

        new SidePanelPage(driver).selectProfile();

        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains("Git"));
    }
}
