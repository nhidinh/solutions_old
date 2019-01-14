package com.hansencx.tests;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.solutionsdemo.actions.Actions;
import org.testng.annotations.Test;

/**
 * GoogleHomePageTests class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-20
 * @see BaseTest
 */
public class SolutionsDemoPageTests extends BaseTest{

    @Test
    public void loginSolutionsDemoPage() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
//        actions.navigateToSolutionLoginPage();
//        Thread.sleep(2000);
//        actions.loginToDashboard("solutions","abc123");
    }
}
