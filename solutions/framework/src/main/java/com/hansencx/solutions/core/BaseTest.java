package com.hansencx.solutions.core;

import utilities.configuration.DriverConfiguration;
import com.hansencx.solutions.reporting.extentreports.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.hansencx.solutions.logger.Log;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * BaseTest class
 *
 * @author  Vi Nguyen, Huong Trinh
 * @version 1.0
 * @since   2018-12-03
 */
public class BaseTest {
    private WebDriver driver;

    /**
     * Constructor
     */
    public WebDriver getDriver(){
        return driver;
    }

    /**
     * For reporting
     */
    @BeforeSuite
    public synchronized void getInstanceForReport(){
        ExtentManager.getInstance();
    }

    /**
     * About reporting: ExtentManager.createNode() will get name of main mode,
     * depended on our design, so this method can be located in BeforeTest/BeforeClass/BeforeSuite
     */

    /**
     * Quit driver after running a test suite
     * @author Huong Trinh
     * @param
     * @return Nothing.
     * @since 2018-12-03
     * @see
     */
    @Parameters({"browser","mode"})
    @BeforeTest
    public void setUp(final String browser, final String mode, ITestContext testContext){
        if(mode.equals("NonRemote")){
            driver = DriverConfiguration.configureDriver(browser);
        }else if(mode.equals("Remote")){
            try {
                driver = DriverConfiguration.configureRemoteDriver(browser);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();

        String testCaseName = testContext.getName();
        Log.startLog();
        Log.startTestCase(testCaseName);
        ExtentManager.createRootNode(testContext.getName());
    }

//    @BeforeTest
    public void SetUpLoggerBeforeTest(ITestContext context) {
        String testCaseName = context.getName();
        Log.startLog();
        Log.startTestCase(testCaseName);
    }


    /**
     * createst for Reporting
     * @author Huong Trinh
     * @param method
     * @return Nothing.
     * @since 2018-12-03
     * @see ITestContext
     */
    @BeforeMethod
    public synchronized void createTestForReport(Method method, ITestContext testContext){
        ExtentManager.createTest(method);
    }

    /**
     * create Report
     * @author Huong Trinh
     * @param method
     * @return Nothing.
     * @since 2018-12-03
     * @see ITestContext, {@link ITestResult}
     */
    @AfterMethod
    public synchronized void createReport(ITestResult result, Method method, ITestContext testContext){
        ExtentManager.generateReport(result, method);
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
        String testCaseName = testContext.getName();
        Log.endTestCase(testCaseName);
        Log.info("Closing browser after test");
        if(null != driver){
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

//    @AfterTest
    public void EndingTest(ITestContext context) {
        String testCaseName = context.getName();
        Log.endTestCase(testCaseName);
        Log.info("Closing browser after test");
    }


    @AfterSuite
    public void EndingLogAfterSuite() {
        Log.info("ENDING SUITE");
        Log.endLog();
    }
}