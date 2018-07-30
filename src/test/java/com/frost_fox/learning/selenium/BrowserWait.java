package com.frost_fox.learning.selenium;

import com.google.common.base.Function;
import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BrowserWait {
    public WebElement shortForElement(final By locator, WebDriver driver) {
        return waitFor(locator, driver, 5, 500);
    }

    public void quick(WebDriver driver) {
        wait(driver, 1);
    }


    public void medium(WebDriver driver) {
        wait(driver, 5);
    }

    public void veryLong(WebDriver driver) {
        wait(driver, 10);
    }

    private WebElement waitFor(final By locator, WebDriver driver, int duration, int period) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(duration, TimeUnit.SECONDS)
                .pollingEvery(period, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    private void wait(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
