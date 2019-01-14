package com.hansencx.tests;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.solutionsdemo.actions.Actions;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    @Test
    public void loginSolutionsDemoPage() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");
    }
}
