package com.telran.tests;

import com.telran.data.BookData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectBookStoreApp();
    }

    @Test
    public void searchBookPositiveTest(){
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook(BookData.BOOK_NAME).contains(BookData.BOOK_NAME));
    }
}
