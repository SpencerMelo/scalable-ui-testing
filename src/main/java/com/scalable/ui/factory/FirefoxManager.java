package com.scalable.ui.factory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxManager extends DriverManager {
    private GeckoDriverService geckoDriverService;

    @Override
    protected void startService() throws IOException {
        geckoDriverService = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("geckodriver.exe"))
                .usingAnyFreePort()
                .build();
        geckoDriverService.start();
    }

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver(geckoDriverService);
    }

    @Override
    public WebDriver createRemoteDriver(String url) throws MalformedURLException {
        Capabilities capabilities = new FirefoxOptions();
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    @Override
    public WebDriver createRemoteDriver() throws MalformedURLException {
        Capabilities capabilities = new FirefoxOptions();
        return new RemoteWebDriver(new URL(HUB_URL), capabilities);
    }

    @Override
    protected void stopService() {
        if (geckoDriverService != null && geckoDriverService.isRunning()) geckoDriverService.stop();
    }
}
