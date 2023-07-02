package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By signInButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.cssSelector("[data-automation-id='login-failure-help-message']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        System.out.println("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSignInButton() {
        System.out.println("Clicking on Sign In Button");
        click(signInButton);
        return new ProfilePage(driver);
    }

    public String getLogInErrorMessage() {
        waitVisibilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}
