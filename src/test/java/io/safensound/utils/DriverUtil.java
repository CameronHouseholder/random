package io.safensound.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.safensound.support.Constants;

public class DriverUtil {

	// util variables
	private static WebDriver driver;
	private static ChromeOptions options;

	public static WebDriver getNewDriver(String browser) {
		switch (browser) {
		case Constants.CHROME:
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("--start-maximized", "--incognito");
			driver = new ChromeDriver(options);
			break;
		case Constants.CHROME_HEADLESS:
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--start-maximized");
			driver = new ChromeDriver(options);
			break;
		case Constants.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}
}