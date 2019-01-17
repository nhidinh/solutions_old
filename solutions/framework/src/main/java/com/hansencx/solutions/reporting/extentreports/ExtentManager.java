package com.hansencx.solutions.reporting.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hansencx.solutions.logger.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.configuration.InitialData;
import utilities.ultils.FileHelper;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import static org.apache.commons.io.FilenameUtils.separatorsToSystem;

/**
 * ExtentManager class (IN DEVELOPING...)
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since
 */
public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    private static ExtentTest parent;
    private static ExtentTest child;

    private static String reportDir_path;

    /**
     * Get instance of ExtentHtmlReporter
     * @author Huong Trinh
     * @param
     * @return ExtentReports object
     * @since   03.01.2019
     * @see ExtentReports
     */
    public final static ExtentReports getInstance( ) {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    /**
     * Create instance of ExtentHtmlReporter, load extent-config.xml file
     * @author Huong Trinh
     * @param
     * @return ExtentReport object
     * @since   03.01.2019
     */
    private static ExtentReports createInstance() {
        String fileName = setReportFileName();
        FileHelper.createDirectory(reportDir_path);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.loadXMLConfig(new File(InitialData.REPORT_CONFIG_XML_FILE_PATH));

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    /**
     * Create Node to listen for report.
     * @author Huong Trinh
     * @param displayedName is used to get name of class/testcontext(upper level)
     * @return void
     * @since   03.01.2019
     */

    public static void createRootNode(ExtentReports extent,String displayedName){
        parent = extent.createTest(displayedName);
        parentTest.set(parent);
    }

    /**
     * Create Test to listen for report data from methods.
     * @author Huong Trinh
     * @param  testDescription is used to get name of method
     * @return void
     * @since   03.01.2019
     */

    public static void createTest(String testDescription){
        System.out.println(" create test " + parentTest.get());
        child = parentTest.get().createNode(testDescription);
        test.set(child);
    }

    /**
     * Get Extent Report Test
     * @author Nhi Dinh
     * @return ExtentTest
     * @since   17.01.2019
     */

    public static ThreadLocal<ExtentTest> getTest(){
        return test;
    }

    /**
     * setReportFileName
     * @author Nhi Dinh
     * @return String
     * @since   17.01.2019
     */

    private static String setReportFileName() {
        reportDir_path = separatorsToSystem(InitialData.REPORT_DIR_PATH);
        String reportFile_path = separatorsToSystem(InitialData.REPORT_FILE_PATH);
        return reportFile_path;
    }

    public static String getBase64Screenshot(WebDriver driver, String screenshotName) throws IOException {
        String encodedBase64 = null;
        FileInputStream fileInputStream = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = reportDir_path + "\\FailedTestsScreenshots\\" + screenshotName + InitialData.TIMESTAMP + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);

        try {
            fileInputStream = new FileInputStream(finalDestination);
            byte[] bytes = new byte[(int) finalDestination.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return encodedBase64;
    }

}
