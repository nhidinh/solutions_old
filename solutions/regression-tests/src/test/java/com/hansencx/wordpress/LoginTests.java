package com.hansencx.wordpress;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.solutionsdemo.actions.Actions;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginSuccessfully()throws InterruptedException{
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");
        actions.verifyLoggingInSuccesssfully();
        actions.logOut();
    }

    @Test
    public void loginUnsuccessfully()throws InterruptedException{
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginUnsuccessfullyToDashboard("solutions","abc12");
        Thread.sleep(10000);
        actions.verifyLoggingInUnSuccesssfully();
    }
}
