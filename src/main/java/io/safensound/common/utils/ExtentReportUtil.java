package io.safensound.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportUtil {
    // util variables
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentReports extent = getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            // Set HTML reporting file location
            extent = new ExtentReports("target/extent-report/ExtentReport.html", true);
            extent.loadConfig(new File("src/test/resources/extent-config.xml"));
        }
        return extent;
    }
}