package com.scalable.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends BasePage {
    private static final int WAIT_TIMEOUT = 15;
    private static final String URL = "https://www.google.com";

    @FindBy(css = "img[alt='Google']")
    private WebElement googleImage;

    @FindBy(css = "input[value='Pesquisa Google']")
    private WebElement searchButton;

    @FindBy(css = "input[title='Pesquisar']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='top_nav']//*[text()='Imagens']")
    private WebElement imagesLink;

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goTo(){
        webDriver.get(URL);
    }

    public void search() {
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public void searchBy(String text) {
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(text);
    }

    public void images() {
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(imagesLink));
        imagesLink.click();
    }
}
