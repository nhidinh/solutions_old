package com.hansencx.wordpress;

import com.hansencx.solutions.core.BaseTest;
import com.hansencx.solutions.pages.MediaLibraryPage;
import com.hansencx.solutions.solutionsdemo.actions.Actions;
import org.testng.annotations.Test;
import utilities.ultils.Fields;


public class MediaTests extends BaseTest {

    //@Test(description = "Upload Image by Browse Button")
    public void uploadImageByBrowseButton() throws InterruptedException {

        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");

        actions.navigateToMediaLibrary();
        actions.uploadNewFile(Fields.IMAGE_PATH);
        // Need to verify if the file is uploaded successfully
    }

    @Test (description = "Upload Image")
    public void UploadImage() throws InterruptedException{

        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");

        actions.navigateToMediaLibrary();
        actions.uploadFile(Fields.IMAGE_PATH);
    }

    //@Test(description = "Upload Image By Drag Drop")
    public void UploadImageByDragDrop() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.navigateToSolutionsDemoPage();
        Thread.sleep(2000);
        actions.navigateToSolutionLoginPage();
        Thread.sleep(2000);
        actions.loginSuccessfullyToDashboard("solutions","abc123");

        actions.navigateToMediaLibrary();
        actions.uploadFileByDragAnđrop(Fields.IMAGE_PATH);
    }
}
