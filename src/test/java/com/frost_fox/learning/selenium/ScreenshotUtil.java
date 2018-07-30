package com.frost_fox.learning.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String pathTo(String filename){
        return System.getProperty("user.dir") + "/res/test/screens/" + filename;
    }

    public static BufferedImage take(WebDriver driver) throws IOException {
        return ImageIO.read(makeScreenShoot(driver));
    }

    public static void save(WebDriver driver, String path) throws IOException {
        FileUtils.copyFile(makeScreenShoot(driver), new File(path));
    }

    private static File makeScreenShoot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
}
