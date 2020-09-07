package com.scalable.ui.factory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeManager extends DriverManager {
    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService() throws IOException {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        chromeDriverService.start();
    }

    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }

    @Override
    public WebDriver createRemoteDriver(String url) throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    @Override
    public WebDriver createRemoteDriver() throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        return new RemoteWebDriver(new URL(HUB_URL), capabilities);
    }

    @Override
    protected void stopService() {
        if(chromeDriverService != null && chromeDriverService.isRunning()) chromeDriverService.stop();
    }
}
