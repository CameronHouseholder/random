package io.safensound.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
	// browsers
	public final static String CHROME = "chrome";
	public final static String CHROME_HEADLESS = "chrome headless";
	public final static String FIREFOX = "firefox";
	// platforms
	public final static String WINDOWS = "windows";
	public final static String LINUX = "linux";
	private final static String platform = System.getProperty("platform") == null ? "windows" : System.getProperty("platform");
	// driver paths
	public final static String CHROME_DRIVER_PATH_WINDOWS = "src/main/resources/webdrivers/windows/chromedriver.exe";
	public final static String CHROME_DRIVER_PATH_LINUX = "src/main/resources/webdrivers/linux/chromedriver";
	public final static String FIREFOX_DRIVER_PATH_WINDOWS = "src/main/resources/webdrivers/windows/geckodriver.exe";
	public final static Map<String, String> CHROME_DRIVER_PATH_MAP = new HashMap<>();
	public final static Map<String, String> FIREFOX_DRIVER_PATH_MAP = new HashMap<>();
	// util variables
	private static WebDriver driver;
	private static ChromeOptions options;

	static {
		// chrome
		CHROME_DRIVER_PATH_MAP.put(WINDOWS, CHROME_DRIVER_PATH_WINDOWS);
		CHROME_DRIVER_PATH_MAP.put(LINUX, CHROME_DRIVER_PATH_LINUX);
		// firefox
		FIREFOX_DRIVER_PATH_MAP.put(WINDOWS, FIREFOX_DRIVER_PATH_WINDOWS);
	}

	public static WebDriver getNewDriver(String browser) {
		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH_MAP.get(platform));
			options = new ChromeOptions();
			options.addArguments("--start-maximized", "--incognito");
			driver = new ChromeDriver(options);
			break;
		case CHROME_HEADLESS:
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH_MAP.get(platform));
			options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--start-maximized");
			driver = new ChromeDriver(options);
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH_MAP.get(platform));
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}
}