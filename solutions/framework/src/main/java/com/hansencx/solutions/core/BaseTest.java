package com.hansencx.solutions.core;

import com.aventstack.extentreports.ExtentReports;
import com.hansencx.solutions.reporting.extentreports.ExtentManager;
import utilities.configuration.DriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.hansencx.solutions.logger.Log;
import utilities.configuration.driver.DriverType;
import utilities.ultils.Browser;

import java.net.MalformedURLException;

/**
 * BaseTest class
 *
 * @author  Vi Nguyen, Huong Trinh
 * @version 1.0
 * @since   2018-12-03
 * @Updated Nhi Dinh 17/01/2019
 *
 */
public class BaseTest {
    private WebDriver driver;
    private static ExtentReports extent;

    /**
     * Constructor
     */
    public WebDriver getDriver(){
        return driver;
    }


    @BeforeSuite
    public void SettingReportBeforeSuite(ITestContext iTestContext){
        extent = ExtentManager.getInstance();
        String suiteName = iTestContext.getCurrentXmlTest().getSuite().getName();
        ExtentManager.createRootNode(extent, suiteName);
    }

    @Parameters({"browser","mode"})
    @BeforeTest
    public void setUp(final DriverType browser, final String mode, ITestContext testContext){
        if(mode.equals("NonRemote")){
            Browser.Setup(browser, testContext);
            driver = (WebDriver) testContext.getAttribute("driver");
        }else if(mode.equals("Remote")){
            try {
                driver = DriverConfiguration.configureRemoteDriver(browser.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        Browser.Maximize();
    }

    @BeforeTest
    public void SetUpLoggerBeforeTest(ITestContext testContext) {
        String testCaseName = testContext.getName();
        Log.startLog();
        Log.startTestCase(testCaseName);
    }

    /**
     * Quit driver after running a test suite
     * @author Huong Trinh
     * @param
     * @return Nothing.
     * @since 2018-12-03
     * @see ITestContext
     */
    @AfterTest
    public synchronized void clean(ITestContext testContext){
        extent.flush();
        String testCaseName = testContext.getName();
        Log.endTestCase(testCaseName);
        Log.info("Closing browser after test");
        Browser.Quit();
    }

    @AfterSuite
    public void EndingLogAfterSuite() {
        Log.info("ENDING SUITE");
        Log.endLog();
    }
}