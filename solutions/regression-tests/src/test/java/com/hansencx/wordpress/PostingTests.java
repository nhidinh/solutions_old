package com.hansencx.wordpress;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.solutionsdemo.actions.Actions;
import org.testng.annotations.Test;

public class PostingTests extends BaseTest {
    @Test
    public void addNewPost() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");


        actions.navigateToAllPostSection();
        actions.navigateToAddNewPostSecton();
        actions.addNewPost("Test Title", "Test Body");
        Thread.sleep(2000);
        actions.verifyPostingSuccessfully();
    }
}
