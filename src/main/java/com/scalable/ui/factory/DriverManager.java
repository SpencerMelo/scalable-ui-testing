package com.scalable.ui.factory;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public abstract class DriverManager {
    protected static final String HUB_URL = "http://localhost:4444/";

    protected abstract void startService() throws IOException;

    public abstract WebDriver createDriver();

    public abstract WebDriver createRemoteDriver(String url) throws MalformedURLException;

    public abstract WebDriver createRemoteDriver() throws MalformedURLException;

    protected abstract void stopService();
}
