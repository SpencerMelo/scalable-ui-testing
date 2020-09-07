package com.scalable.ui.test;

import com.scalable.ui.factory.ChromeManager;
import com.scalable.ui.page.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class RaptorsTest {
    private GooglePage googlePage;
    private WebDriver webDriver;

    @BeforeEach
    void setup() throws MalformedURLException {
        webDriver = new ChromeManager().createDriver();
        googlePage = new GooglePage(webDriver);
    }

    @Test
    public void userShouldBeAbleToSeeEagleImages(){
        googlePage.goTo();
        googlePage.searchBy("Eagle");
        googlePage.search();
        googlePage.images();
    }

    @Test
    public void userShouldBeAbleToSeeHawkImages(){
        googlePage.goTo();
        googlePage.searchBy("Hawk");
        googlePage.search();
        googlePage.images();
    }

    @AfterEach
    public void tearDown(){
        if(webDriver != null) webDriver.quit();
    }
}
