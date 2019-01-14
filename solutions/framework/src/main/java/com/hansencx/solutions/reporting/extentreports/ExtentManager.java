package com.hansencx.solutions.reporting.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import utilities.ultils.Fields;

import java.io.File;
import java.lang.reflect.Method;

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

    /**
     * Get instance of ExtentHtmlReporter
     * @author Huong Trinh
     * @param
     * @return ExtentReports object
     * @since   03.01.2019
     * @see ExtentReports
     */
    public final static ExtentReports getInstance() {
        if (extent == null)
            createInstance(Fields.ROOT_DIRECTORY + "\\regression-tests\\reports\\"+ "Extent.html");
        return extent;
    }

    /**
     * Create instance of ExtentHtmlReporter, load config of report from extent-config.xml
     * @author Huong Trinh
     * @param fileName output report name, stored location, provide link
     * @return ExtentReport object
     * @since   03.01.2019
     */
    private static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\regression-tests\\src\\test\\java\\config\\extent-config.xml"));

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

    public static void createRootNode(String displayedName){
        parent = extent.createTest(displayedName);
        parentTest.set(parent);
    }

    /**
     * Create Test to listen for report data from methods.
     * @author Huong Trinh
     * @param method is used to get name of method
     * @return void
     * @since   03.01.2019
     */

    public static void createTest(Method method){
        System.out.println(" create test " + parentTest.get());

        child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    /**
     * GenerateReport and set the status of tests
     * @author Huong Trinh
     * @param result is used to get status
     * @param method is used to get name of methods
     * @return void
     * @since   03.01.2019
     */
    public static void generateReport(ITestResult result, Method method){
        if(result.getStatus() == ITestResult.FAILURE){
            test.get().fail(result.getThrowable());
        }else if(result.getStatus() ==ITestResult.SKIP){
            test.get().skip(result.getThrowable());
        }else {
            test.get().pass("Test Methods " + method.getName() + " Passed" );
        }
        extent.flush();
    }
}
