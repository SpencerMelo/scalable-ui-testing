package com.scalable.ui.test;

import com.scalable.ui.factory.ChromeManager;
import com.scalable.ui.page.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class CanineTest {
    private GooglePage googlePage;
    private WebDriver webDriver;

    @BeforeEach
    void setup() throws MalformedURLException {
        webDriver = new ChromeManager().createDriver();
        googlePage = new GooglePage(webDriver);
    }

    @Test
    public void userShouldBeAbleToSeeDogImages(){
        googlePage.goTo();
        googlePage.searchBy("Dog");
        googlePage.search();
        googlePage.images();
    }

    @Test
    public void userShouldBeAbleToSeeWolfImages(){
        googlePage.goTo();
        googlePage.searchBy("Wolf");
        googlePage.search();
        googlePage.images();
    }

    @AfterEach
    public void tearDown(){
        if (webDriver != null) webDriver.quit();
    }
}
