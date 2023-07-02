package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private final By editProfileButton = By.xpath("//*[@id=\"profileLink\"]/h2");
    private final By advancedSearchButton = By.id("submitSearch-button");
    private final By profileContactNameText = By.id("contact-first-name");
    protected ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageToLoad() {
        System.out.println("Waiting For Profile Page To Load");
        waitVisibilityOf(editProfileButton);
        waitVisibilityOf(advancedSearchButton, 10);
    }

    public boolean isCorrectProfileLoaded(String correctProfileName) {
        return getText(profileContactNameText).equals(correctProfileName);
    }
}
