package io.safensound.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends Page {

    // page elements
    private By txtSearch = By.cssSelector("input[title='Search']");
    private By btnSearch = By.cssSelector("input[value='Google Search']");

    // page variables
    private static final String PAGE_URL = "https://www.google.com/";

    // page constructor
    private GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public static GoogleHomePage init(WebDriver driver) {
        return new GoogleHomePage(driver);
    }

    // page actions
    public GoogleHomePage open() {
        super.open(PAGE_URL);
        return this;
    }

    public GoogleHomePage setSearchText(String text) {
        setText(txtSearch, text);
        return this;
    } 

    public void clickSearch() {
        click(btnSearch);
    }
}