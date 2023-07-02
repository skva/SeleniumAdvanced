package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            default -> new FirefoxDriver();
        };
        driver.manage().window().maximize();
        return driver;
    }
}
