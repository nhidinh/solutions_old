package com.hansencx.solutions.solutionsdemo.actions;

import com.hansencx.solutions.core.BaseAction;
import com.hansencx.solutions.pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Actions class
 *
 * @author  Vi Nguyen
 * @version 1.0
 * @since   2018-12-20
 * @see BaseAction
 */
public class Actions extends BaseAction{

    private SolutionsDemoPage solutionsDemoPage = new SolutionsDemoPage(driver);

    private static LoginPage loginPage;
    private static LoginFailurePage loginFailurePage;
    private static DashboardPage dashboardPage;
    private static MediaLibraryPage mediaLibraryPage;
    private static AllPostsPage allPostsPage;
    private static AddNewPostPage addNewPostPage;

    /**
     * Constructor
     */
    public Actions(WebDriver driver){
        super(driver);
    }

    /**
     * Navigate to SolutionsDemo page
     * @author Vi Nguyen
     * @param
     * @return Nothing.
     * @since 2018-12-20
     * @see
     */
    public void navigateToSolutionsDemoPage(){
        solutionsDemoPage.navigateTo();
    }

    public void navigateToSolutionLoginPage(){this.loginPage = solutionsDemoPage.clickOnLoginLink();}

    public void loginSuccessfullyToDashboard(String username, String password) throws InterruptedException {
        dashboardPage = this.loginPage.loginSuccessfully(username, password);
    }

    public void loginUnsuccessfullyToDashboard(String username, String password) throws InterruptedException {
        loginFailurePage = this.loginPage.loginUnsuccessfully(username, password);
    }
    public void verifyLoggingInSuccesssfully(){
        dashboardPage.verifyElementPresent(dashboardPage.getTitle());
    }

    public void verifyLoggingInUnSuccesssfully(){
        loginFailurePage.verifyElementPresent(loginFailurePage.getErrorText());
    }

    public void logOut(){
        dashboardPage.logOut();
    }

    public void navigateToMediaLibrary(){
        mediaLibraryPage = dashboardPage.navigateToMediaLibrarySection();
    }

    public void uploadNewFile(String filePath){
        mediaLibraryPage.getBtnAddNew().click();
        mediaLibraryPage.uploadFileByBrowseButton(filePath);
    }

    public void uploadFile(String filePath){
        mediaLibraryPage.getBtnAddNew().click();
        mediaLibraryPage.uploadFile(filePath);
    }

    public void uploadFileByDragAnđrop(String filePath){
        mediaLibraryPage.getBtnAddNew().click();
        mediaLibraryPage.uploadFileByDragDrop(filePath);
    }

    public void navigateToAllPostSection() throws InterruptedException {
        allPostsPage = dashboardPage.navigateToAllPostSection();
    }

    public void navigateToAddNewPostSecton(){
        addNewPostPage = allPostsPage.navigateToAddNewPostSection();
    }
    public void addNewPost(String title, String body) throws InterruptedException {
        addNewPostPage.addNewPost(title, body);
    }

    public void verifyPostingSuccessfully(){
        addNewPostPage.verifyPostingSuccessfully();
    }
}
