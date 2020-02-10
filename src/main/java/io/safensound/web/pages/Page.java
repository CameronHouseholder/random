package io.safensound.web.pages;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import io.safensound.common.configs.EnvironmentConfig;

public class Page {
    
    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;

    //private EnvironmentConfig environment;

    // page variables
    private static final long DEFAULT_TIMEOUT = 20;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        // setup environment
        //environment = ConfigFactory.create(EnvironmentConfig.class);
    }

    /**
     * open the current browser to the provided url
     * @param url url to open in the current browser
     */
    public void open(String url) {
        // driver.get(environment.getBaseUrl() + url);
    }

    /**
     * locate the element using the provided By and return the WebElement
     * @param by mechanism used to locate elements
     * @return WebElement
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * wait for the element to be visible in the DOM within the timeout period or throw an error
     * @param element element in the DOM
     */
    public void waitForVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * wait for the element to be displayed in the DOM then set it's value
     * @param by mechanism used to locate elements
     * @param text text to set the element's value to
     */
    public void setText(By by, String text) {
        element = findElement(by);
        waitForVisibilityOf(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * wait for the element to be displayed in the DOM then click it
     * @param by mechanism used to locate elements
     */
    public void click(By by) {
        element = findElement(by);
        waitForVisibilityOf(element);
        element.click();
    }

    /**
     * returns a boolean based on if the element is displayed in the DOM
     * @param by mechanism used to locate elements
     * @return boolean
     */
    public boolean isDisplayed(By by) {
		boolean isDisplayed = false;
		try {
			isDisplayed = findElement(by).isDisplayed();
		} catch (NoSuchElementException ex) {}
		return isDisplayed;
    }
}