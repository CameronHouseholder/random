package io.safensound;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import io.safensound.pages.GoogleHomePage;
import io.safensound.pages.GoogleSearchResultsPage;
import io.safensound.utils.DriverUtil;
import static io.safensound.utils.ExtentReportUtil.*;

public class SafeNSoundGoogleSearchIT extends BaseIT {

    private WebDriver driver;

    // pages
    private GoogleSearchResultsPage googleSearchResults;

    @Parameters({ "browser" })
    @BeforeTest
    public void beforeTest(String browser) {
        driver = DriverUtil.getNewDriver(browser);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Parameters({ "browser" })
    @Test (enabled = true)
    public void safeNSoundGoogleSearch(String browser) {
        // start test for report
        startTest("safeNSoundGoogleSearch", "search for safensound.io link on google");
        getTest().assignCategory(browser);
        // google search for safeNSound
        GoogleHomePage.init(driver)
            .open()
            .setSearchText("spacelabs safensound")
            .clickSearch();
        // assert that the link for safensound.io exists
        googleSearchResults = GoogleSearchResultsPage.init(driver); 
        assertThat(googleSearchResults.lnkSafeNSoundIsDisplayed()).as("safensound.io link exists").isTrue();  
    }
}
