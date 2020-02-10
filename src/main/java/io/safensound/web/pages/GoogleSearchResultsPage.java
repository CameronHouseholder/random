package io.safensound.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage extends Page {

    // page elements
    private By lnkSafeNSound = By.cssSelector("a[href='https://www.safensound.io/']");

    // page constructor
    private GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public static GoogleSearchResultsPage init (WebDriver driver) {
        return new GoogleSearchResultsPage(driver);
    }

    // page actions
    public boolean lnkSafeNSoundIsDisplayed() {
        return isDisplayed(lnkSafeNSound);
    }
}