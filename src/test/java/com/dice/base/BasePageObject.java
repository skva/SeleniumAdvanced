package com.dice.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    protected void getPage(String url) {
        driver.get(url);
    }

    protected void type(String text, By element) {
        driver.findElement(element).sendKeys(text);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void waitVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? Duration.ofSeconds(timeOutInSeconds[0]) : null));
                break;
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
    }

    protected void waitFor(ExpectedCondition<WebElement> condition, Duration timeout) {
        timeout = timeout != null ? timeout : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected String getText(By element) {
        return find(element).getText();
    }
}
