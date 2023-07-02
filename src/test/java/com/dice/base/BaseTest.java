package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({ "browser"})
    @BeforeMethod
    protected void methodSetIp(String browser) {
        System.out.println("Method Set Up");
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod
    protected void methodTearDown() {
        System.out.println("Method Tear Down");
        driver.quit();
    }
}
