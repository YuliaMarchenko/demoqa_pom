package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks extends BasePage {
    public BrokenLinks(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public BrokenLinks checkAllLinks() {
        System.out.println("Total links: " + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrokenLinks checkBrokenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " " + httpURLConnection.getResponseMessage() + " is broken link");
            } else {
                System.out.println(linkUrl + " " + httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            System.out.println(linkUrl + " " + e.getMessage() + " is broken link");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> img;

    public BrokenLinks checkBrokenImages() {
        System.out.println(img.size());

        for (int i = 0; i < img.size(); i++) {
            WebElement element = img.get(i);
            String imageUrl = element.getAttribute("src");
            verifyLinks(imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);", element);
                if (imageDisplayed) {
                    System.out.println("OK");
                    System.out.println("*******************************");
                } else {
                    System.out.println("BROKEN");
                }
            } catch (Exception e){
                System.out.println("Error");
            }
        }

        return this;
    }
}
