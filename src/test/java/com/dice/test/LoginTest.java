package com.dice.test;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLogInTest() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedPageTitle = "Dashboard Home Feed | Dice.com";
        String correctProfileName = "Evgeny";

        loginPage.openLoginPage();
        loginPage.fillUpEmailAndPassword("skva1er@yandex.ru", "Automation2017");
        ProfilePage profilePage = loginPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        System.out.println("Verifications");
        String actualTitle = profilePage.getTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle, "Page title is not expected.\nExpected: "
                 + expectedPageTitle + "\nActual: " + actualTitle);
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
     }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLogInTest(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        System.out.println("Test #" + testNumber + " for " + description + " where\nEmail: " + email + "\nPassword: "
            + password + "\n");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.fillUpEmailAndPassword(email, password);
        loginPage.pushSignInButton();

        String errorMessage = loginPage.getLogInErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage), "Error message is not expected\nExpected: "
                + expectedErrorMessage + "\nActual: " + errorMessage);
    }
}
