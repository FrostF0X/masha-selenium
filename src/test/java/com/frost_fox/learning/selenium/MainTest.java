package com.frost_fox.learning.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MainTest {

    private BrowserWait browserWait = new BrowserWait();

    @Test
    public void mainTest() throws IOException {
        WebDriver browser = BrowserFactory.Default();

        browser.get("https://vk.com");


        WebElement email = browser.findElement(By.id("index_email"));
        email.sendKeys("+380934677395");
        ScreenshotUtil.save(browser, "test.png");
        System.out.print(email.getAttribute("value"));

        WebElement pass = browser.findElement(By.id("index_pass"));
        pass.sendKeys("rty1fgh2vbn3");

        WebElement submit = browser.findElement(By.id("index_login_button"));
        submit.click();

        browserWait.shortForElement(By.cssSelector("a[href*='/im']"), browser).click();
        browserWait.shortForElement(By.cssSelector("li[data-list-id='176587549'"), browser).click();
        browserWait.shortForElement(By.id("im_editable0"), browser).sendKeys("Кыця какашка ❤");
        browserWait.shortForElement(By.cssSelector(".im-send-btn.im-chat-input--send"), browser).click();

        ScreenshotUtil.save(browser, "test2.png");
    }

}
