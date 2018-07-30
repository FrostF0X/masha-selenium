package com.frost_fox.learning.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    private static final String SELENIUM_SERVER_URL = "http://localhost:4444/wd/hub";

    public static WebDriver Default() throws MalformedURLException {
        return new RemoteWebDriver(new URL(SELENIUM_SERVER_URL),
                DesiredCapabilities.chrome());
    }
}
