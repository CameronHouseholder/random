package io.safensound;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.safensound.utils.ExtentReportUtil.*;

public class BaseIT {
    // extent reports
    public static ExtentTest logger;

    @BeforeSuite()
    public void beforeSuite() {
        getReporter();
    }

    @AfterSuite()
    public void afterSuite() {
        getReporter().flush();
    } 

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        logger = getTest();
        int status = result.getStatus();
        if (status == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Failed.");
        } else if (status == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Passed.");
        } else {
            logger.log(LogStatus.SKIP, "Test Skipped.");
        }
        endTest();
    }
}