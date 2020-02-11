package io.safensound.utils;

import com.vaadin.testbench.TestBenchTestCase;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class PageUtil extends TestBenchTestCase {

    private WebDriver driver;

    // constructor
    private PageUtil(WebDriver driver) {
        this.driver = driver;
    }

    public static PageUtil init(WebDriver driver) {
        return new PageUtil(driver);
    }

    public void open(String baseUrl, String pageUrl) {
        var url = baseUrl + pageUrl;
        get(url);
    }

    @Step("Opening the browser at: {0}")
    private void get(String url) {
        driver.get(url);
    }
}