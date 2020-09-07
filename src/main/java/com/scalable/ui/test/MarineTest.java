package com.scalable.ui.test;

import com.scalable.ui.factory.ChromeManager;
import com.scalable.ui.page.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class MarineTest {
    private GooglePage googlePage;
    private WebDriver webDriver;

    @BeforeEach
    void setup() throws MalformedURLException {
        webDriver = new ChromeManager().createDriver();
        googlePage = new GooglePage(webDriver);
    }

    @Test
    public void userShouldBeAbleToSeeWhaleImages(){
        googlePage.goTo();
        googlePage.searchBy("Whale");
        googlePage.search();
        googlePage.images();
    }

    @Test
    public void userShouldBeAbleToSeeDolphinImages(){
        googlePage.goTo();
        googlePage.searchBy("Dolphin");
        googlePage.search();
        googlePage.images();
    }

    @AfterEach
    public void tearDown(){
        if (webDriver != null) webDriver.quit();
    }
}
